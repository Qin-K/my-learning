package com.qin_kai.springtest.aop;

import org.springframework.stereotype.Component;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
@Component
public class Performer {

    public void perform() {
        System.out.println("表演者正在表演。。。");
    }
}
