package com.qin_kai.spring.core.assemblebean;

import org.springframework.stereotype.Component;

/**
 * @author qin kai
 * @Date 2020/8/24
 */
//@Component("compactDisc") 指定bean name
//@Component
public class CompactDisc {

    public void play() {
        System.out.println("compact disc is playing...");
    }
}
