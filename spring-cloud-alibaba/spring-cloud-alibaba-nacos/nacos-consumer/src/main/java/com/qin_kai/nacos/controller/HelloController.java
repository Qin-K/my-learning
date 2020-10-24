package com.qin_kai.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author qin kai
 * @date 2020/9/8
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String url = serviceInstance.getUri() + "/hello?name=" + name;
        logger.info("invoke url {}", url);
        return restTemplate.getForObject(url, String.class);
    }

}
