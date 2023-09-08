package com.qin_kai.spi.impl;

import com.qin_kai.spi.api.Demo;

/**
 * @author qinkai
 * @date 2023/9/8
 */
public class DemoImpl implements Demo {
    @Override
    public void demo() {
        System.out.println("I'm demo impl");
    }
}
