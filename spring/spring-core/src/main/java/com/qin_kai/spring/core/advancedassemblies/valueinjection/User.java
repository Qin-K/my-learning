package com.qin_kai.spring.core.advancedassemblies.valueinjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author qin kai
 * @date 2020/8/25
 */
@Component
@PropertySource("classpath:user.properties")
public class User {

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
