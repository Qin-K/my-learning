package com.qin_kai.annotation.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author qinkai
 * @date 2020/11/25
 */
@Component
@Async
public class AsyncDemo2 {

    public void test1() {
        System.out.println(Thread.currentThread());
    }

    public void test2() {
        System.out.println(Thread.currentThread());
    }

}
