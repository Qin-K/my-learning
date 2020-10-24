package com.qin_kai.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qin kai
 * @date 2020/9/5
 */
@RestController
public class HelloController {

    @Value("${hello}")
    private String hello;

    @GetMapping("/hello")
    public String hello() {
        return hello;
    }
}
