package com.qin_kai.java;

/**
 * @author qinkai
 * @date 2020/11/4
 */
public class StringDemo {

    public static void main(String[] args) {
        String greeting = "hello";
        // 子串
        String s = greeting.substring(0, 3);
        System.out.println(s);
        // 拼接
        String expletive = "Expletive";
        String PG13 = "deleted";
        String message = expletive + PG13;
        System.out.println(message);
        int age = 13;
        String rating = "PG" + age;
        System.out.println(rating);

        // 用一个定界符分隔拼接多个字符串
        String all = String.join(" / ", "S", "M", "L", "XL");
        System.out.println(all);

        // 检测字符串是否相等s.equals(t)
        System.out.println("hello".equals(greeting));
    }

}
