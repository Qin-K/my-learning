package com.qinkai.createpattern;

/**
 * 饿汉式单例
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance(){
        return instance;
    }

}
