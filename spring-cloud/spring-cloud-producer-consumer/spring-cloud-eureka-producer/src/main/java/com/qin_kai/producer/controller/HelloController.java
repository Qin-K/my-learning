package com.qin_kai.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qin kai
 * @Date 2020/9/4
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "hello " + name + " I'm is producer";
    }

}
