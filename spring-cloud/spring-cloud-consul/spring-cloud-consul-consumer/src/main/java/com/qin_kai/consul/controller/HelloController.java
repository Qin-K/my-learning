package com.qin_kai.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author qin kai
 * @date 2020/9/11
 */
@RestController
public class HelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-producer");
        return restTemplate.getForObject(serviceInstance.getUri() + "/hello?name=" + name, String.class);
    }

}
