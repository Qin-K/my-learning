package com.qin_kai.demo;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author qin kai
 * @Date 2020/8/24
 */
public class Test {
    public static void main(String[] args) {
//        Reflections reflections = new Reflections("com.qin_kai.demo");

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("com.qin_kai.demo"))
                .setScanners(new SubTypesScanner(),new MethodAnnotationsScanner()
                        , new TypeAnnotationsScanner()));

        Set<Class<? extends SomeType>> subTypes = reflections.getSubTypesOf(SomeType.class);
        System.out.println("sub types of SomeType are\n" + subTypes);

        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(SomeAnnotation.class);
        System.out.println("types annotated with SomeAnnotation are \n" + typesAnnotatedWith);

        Set<Method> methodsAnnotatedWith = reflections.getMethodsAnnotatedWith(SomeAnnotation.class);
        System.out.println("methods annotated with SomeAnnotation are \n" + methodsAnnotatedWith);
    }
}
