package com.qin_kai.springboot.apollo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qinkai
 * @date 2023/8/28
 */
@Component
@ConfigurationProperties(prefix = "test")
public class TestProperties {

    /**
     * 使用@Valud注解的配置可以自动注入
     */
    @Value("${test.test1: default}")
    private String test1;

    private String test2;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }
}
