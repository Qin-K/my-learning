package com.qin_kai.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qin kai
 * @date 2020/9/8
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name;
    }

}
