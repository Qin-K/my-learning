package com.qin_kai.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qin kai
 * @date 2020/9/11
 */
@RestController
public class ServiceController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/services")
    public List<ServiceInstance> services() {
        return discoveryClient.getInstances("service-producer");
    }


    @GetMapping("/discover")
    public String discover() {
        return loadBalancerClient.choose("service-producer").getUri().toString();
    }

}
