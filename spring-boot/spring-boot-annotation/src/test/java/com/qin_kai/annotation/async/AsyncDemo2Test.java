package com.qin_kai.annotation.async;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AsyncDemo2Test {

    @Resource
    private AsyncDemo2 asyncDemo2;

    @Test
    void test() {
        asyncDemo2.test1();
        asyncDemo2.test1();

        asyncDemo2.test2();
        asyncDemo2.test2();
    }
}

