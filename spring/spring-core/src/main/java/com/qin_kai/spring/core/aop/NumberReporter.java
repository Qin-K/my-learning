package com.qin_kai.spring.core.aop;

import org.springframework.stereotype.Component;

/**
 * @author qin kai
 * @date 2020/8/25
 */
@Component
public class NumberReporter {

    public void report(int number) {
        System.out.println("report number " + number);
    }

}
