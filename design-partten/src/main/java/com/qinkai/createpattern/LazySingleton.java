package com.qinkai.createpattern;

/**
 * 懒汉式单例
 */
public class LazySingleton {

    private static volatile LazySingleton instance;

    /**
     * 直接同步方法
     * @return
     */
//    public synchronized static LazySingleton getInstance() {
//        if (instance == null) {
//            instance = new LazySingleton();
//        }
//
//        return instance;
//    }

    /**
     * 使用双重检查
     * @return
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }

        return  instance;
    }



}
