package com.qin_kai.annotation.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author qinkai
 * @date 2020/11/25
 */
@Component
public class AsyncDemo {

    @Async
    public void test1() {
        System.out.println(Thread.currentThread());
    }

    public void test2() {
        System.out.println(Thread.currentThread());
    }

}
