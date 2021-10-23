package com.example.demo1;

import org.springframework.stereotype.Component;

/**
 * @author qin kai
 * @date 2020/8/23
 */
@Component
public class Book {
    private String name = "test";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
