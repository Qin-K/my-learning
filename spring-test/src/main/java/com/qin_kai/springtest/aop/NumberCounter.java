package com.qin_kai.springtest.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
@Component
@Aspect
public class NumberCounter {

    /**
     * 记录 number report count
     * <number, count>
     */
    private Map<Integer, Integer> map = new HashMap<>();

    @Pointcut("execution(* com.qin_kai.springtest.aop.NumberReporter.report(int)) && args(number))")
    public void report(int number){}

    @Before("report(number)")
    public void count(int number) {
        int next = map.getOrDefault(number, 0) + 1;
        map.put(number, next);
    }

    public int getCount(int number) {
        return map.get(number);
    }
}
