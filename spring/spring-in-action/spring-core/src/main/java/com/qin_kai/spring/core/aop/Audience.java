package com.qin_kai.spring.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author qin kai
 * @date 2020/8/25
 */
@Aspect
@Component
public class Audience {

    @Pointcut("execution(* com.qin_kai.spring.core.aop.Performer.perform(..))")
    public void perform() {
    }

    @Before("perform()")
    public void before() {
        System.out.println("前置通知 before 执行。。。");
    }

    @After("perform()")
    public void after() {
        System.out.println("最终通知 after 执行。。。");
    }

    @AfterReturning("perform()")
    public void afterReturning() {
        System.out.println("返回通知 afterReturning 执行。。。");
    }

    @AfterThrowing("perform()")
    public void afterThrowing() {
        System.out.println("异常通知 afterThrowing 执行。。。");
    }

    @Around("perform()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知在连接点之前执行。。。");
        joinPoint.proceed();
        System.out.println("环绕通知在连接点之后执行。。。");
    }

}
