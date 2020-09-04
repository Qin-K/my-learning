package com.qin_kai.hystrix.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qin kai
 * @Date 2020/9/4
 */
@FeignClient(name = "spring-cloud-producer", fallback = HelloRemoteHystrix.class)
@Component
public interface HelloRemote {

    @RequestMapping("/hello")
    String hello1(@RequestParam("name") String name);

}
