package com.qin_kai.annotation.conditional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
class ConditionalOnPropertiesDemoTest {

    @Resource
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        boolean result = applicationContext.containsBean("conditionalOnPropertiesDemo");
        System.out.println(result);
    }

}