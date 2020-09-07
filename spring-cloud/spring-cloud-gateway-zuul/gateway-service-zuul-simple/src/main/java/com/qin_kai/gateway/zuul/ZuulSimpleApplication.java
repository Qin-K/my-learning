package com.qin_kai.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulSimpleApplication.class, args);
    }

}
