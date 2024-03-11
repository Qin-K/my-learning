package com.qin_kai.prometheus;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinkai
 * @date 2024/3/2
 */
@Component
@Aspect
public class HelloMetricAspect {

    @Autowired
    private MeterRegistry meterRegistry;

    @Pointcut("execution(* com.qin_kai.prometheus.controller.HelloController.*(..))")
    void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getDeclaringType().getSimpleName() + "#" + signature.getName();
        Timer timer = getTimer(name);
        Object result = timer.record(() -> {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                return throwable;
            }
        });
        if (result instanceof Throwable) {
            throw (Throwable) result;
        }
        return result;
    }

    private Timer getTimer(String name) {
        return Timer.builder("test.timer")
                .tag("api", name)
                .register(meterRegistry);
    }

}
