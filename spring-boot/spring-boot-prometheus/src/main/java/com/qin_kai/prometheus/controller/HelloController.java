package com.qin_kai.prometheus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qin kai
 * @Date 2020/9/15
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name;
    }

}
