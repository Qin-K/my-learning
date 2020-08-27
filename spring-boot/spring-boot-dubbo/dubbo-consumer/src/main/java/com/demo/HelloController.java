package com.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(String name) {
        String hello = helloService.sayHello(name);
        return hello;
    }
}
