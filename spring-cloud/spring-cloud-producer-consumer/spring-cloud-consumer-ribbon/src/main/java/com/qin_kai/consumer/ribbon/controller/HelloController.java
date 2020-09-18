package com.qin_kai.consumer.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author qin kai
 * @Date 2020/9/18
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://spring-cloud-producer/hello?name=" + name, String.class);
    }

}
