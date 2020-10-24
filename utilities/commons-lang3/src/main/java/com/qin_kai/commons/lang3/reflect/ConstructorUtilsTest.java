package com.qin_kai.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.ConstructorUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author qin kai
 * @date 2020/10/19
 */
public class ConstructorUtilsTest {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // 获取指定构造函数
        Constructor<User> constructor = ConstructorUtils.getAccessibleConstructor(User.class, String.class, Integer.class);

        User user = ConstructorUtils.invokeConstructor(User.class, "qinkai", 18);
//        User user = invokeConstructor(User.class, "qinkai", 18);
        System.out.println(user);
    }

    public static <T> T invokeConstructor(Class<T> tClass, Object ... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?>[] classes = Arrays.stream(args)
                .map(Object::getClass)
                .collect(Collectors.toList()).toArray(new Class[]{});
        Constructor<T> constructor = tClass.getConstructor(classes);
        return constructor.newInstance(args);
    }
}
