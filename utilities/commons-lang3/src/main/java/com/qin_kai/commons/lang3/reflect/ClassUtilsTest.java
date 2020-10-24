package com.qin_kai.commons.lang3.reflect;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.util.List;

/**
 * @author qin kai
 * @date 2020/10/19
 */
public class ClassUtilsTest {

    static class Base {}

    static class Sub extends Base {}

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 通过 ClassUtils 获取类信息
        List<Class<?>> allInterfaces = ClassUtils.getAllInterfaces(Sub.class);
        System.out.println(allInterfaces);
        List<Class<?>> allSuperclasses = ClassUtils.getAllSuperclasses(Sub.class);
        System.out.println(allSuperclasses);

        String packageName = ClassUtils.getPackageName(Sub.class);
        System.out.println(packageName);
        stopWatch.stop();
        System.out.println("spend " + stopWatch.getTime() + " ms");
    }
}
