package com.example;

import com.example.demo1.Book;
import com.example.demo2.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
        Book bean = SpringUtils.getBean(Book.class);
        System.out.println(bean.getName());
    }

}
