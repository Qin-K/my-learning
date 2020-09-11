package com.qin_kai.consul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qin kai
 * @Date 2020/9/11
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name) {
        return "producer: hello " + name;
    }

}
