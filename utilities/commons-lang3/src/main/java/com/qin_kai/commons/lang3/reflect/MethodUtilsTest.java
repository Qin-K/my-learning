package com.qin_kai.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author qin kai
 * @date 2020/10/19
 */
public class MethodUtilsTest {

    public void hello(String name) {
        System.out.println("hello " + name);
    }

    public void test() {
        System.out.println("test");
    }

    public static void staticTest() {
        System.out.println("static test");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        MethodUtilsTest test = new MethodUtilsTest();
        // static
        MethodUtils.invokeStaticMethod(MethodUtilsTest.class, "staticTest");

        MethodUtils.invokeMethod(test, "test");

        MethodUtils.invokeMethod(test, "hello", "qinkai");
    }
}
