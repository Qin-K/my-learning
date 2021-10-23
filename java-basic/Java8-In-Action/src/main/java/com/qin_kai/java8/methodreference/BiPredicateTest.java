package com.qin_kai.java8.methodreference;

import java.util.function.BiPredicate;

/**
 * @author qinkai
 * @date 2020-07-10 15:24:30
 **/
public class BiPredicateTest {

    private int m;

    public BiPredicateTest(int m) {
        this.m = m;
    }

    public boolean test(Integer n) {
        return m == n;
    }

    public static void main(String[] args) {
//        BiPredicate<String, String> b = String::equals;
        BiPredicate<BiPredicateTest, Integer> b = BiPredicateTest::test;
        boolean test = b.test(new BiPredicateTest(2), 2);
        System.out.println(test);
    }

}
