package com.qin_kai.spi.api;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author qinkai
 * @date 2023/9/8
 */
public class DemoTest {

    private static Demo demo;

    static {
        demo = loadDemoInstance();
    }

    public static void test() {
        demo.demo();
    }

    private static Demo loadDemoInstance() {
        ServiceLoader<Demo> loader = ServiceLoader.load(Demo.class);
        Iterator<Demo> iterator = loader.iterator();
        if (!iterator.hasNext()) {
            throw new IllegalStateException("demo impl is not exists");
        }
        Demo demo = iterator.next();
        if (iterator.hasNext()) {
            System.out.println("demo has multi impl");
        }
        return demo;
    }

}
