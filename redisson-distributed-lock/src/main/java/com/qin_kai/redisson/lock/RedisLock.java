package com.qin_kai.redisson.lock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 分布式锁
 *
 * @author qinkai
 * @date 2022/7/21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RedisLock {

    /**
     * 分布式锁的key, 默认为className.methodName
     */
    String key() default "";

    /**
     * 当未获取到锁时，跳过执行，直接返回，否则会一直等待直到获取锁成功
     * 用于只需要方法执行一次的场景
     */
    boolean skip() default false;
}
