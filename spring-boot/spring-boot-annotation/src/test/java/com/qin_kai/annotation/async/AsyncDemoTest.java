package com.qin_kai.annotation.async;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsyncDemoTest {

    @Resource
    private AsyncDemo asyncDemo;

    @Test
    void test() {
        asyncDemo.test1();
        asyncDemo.test1();

        asyncDemo.test2();
        asyncDemo.test2();
    }
}

