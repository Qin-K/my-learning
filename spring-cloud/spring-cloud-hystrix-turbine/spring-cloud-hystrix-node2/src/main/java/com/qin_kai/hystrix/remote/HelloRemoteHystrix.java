package com.qin_kai.hystrix.remote;

import org.springframework.stereotype.Component;

/**
 * @author qin kai
 * @date 2020/9/4
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello2(String name) {
        return "sorry " + name + " some error happened";
    }
}
