package com.qin_kai.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qin kai
 * @Date 2020/9/4
 */
@RestController
public class ConsumerController {
    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }

}
