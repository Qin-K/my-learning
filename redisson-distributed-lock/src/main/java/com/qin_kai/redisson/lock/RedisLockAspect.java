package com.qin_kai.redisson.lock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author qinkai
 * @date 2022/7/21
 */
@Component
@Aspect
public class RedisLockAspect {

    public static final int LEASE_TIME_SECONDS = 10;

    @Pointcut("@annotation(com.qin_kai.redisson.lock.RedisLock)")
    public void lockPointcut() {
    }

    @Around("lockPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        RedisLock lockAnnotation = method.getAnnotation(RedisLock.class);
        String key = lockAnnotation.key();
        if (!StringUtils.hasText(key)) {
            key = method.getDeclaringClass().getName() + "." + method.getName();
        }
        RLock lock = RedisLockUtil.getLock(key);
        boolean lockSuccess = true;
        try {
            if (lockAnnotation.skip()) {
                if (!lock.tryLock()) {
                    lockSuccess = false;
                    return null;
                }
            } else {
                lock.lock(LEASE_TIME_SECONDS, TimeUnit.SECONDS);
            }
            return joinPoint.proceed();
        } finally {
            if (lockSuccess) {
                lock.unlock();
            }
        }
    }

}
