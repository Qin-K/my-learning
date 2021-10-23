package com.qin_kai.java8.ch6_streamcollect;

import com.qin_kai.java8.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 规约和汇总
 *
 * @author qinkai
 * @date 2021/8/19
 */
public class Ch6_2ReduceAndSum {

    private static final List<User> userList = Arrays.asList(new User("test1", 18),
            new User("test2", 19),
            new User("test3", 20));

    public static void main(String[] args) {
        // 求数等同于count()终端操作
//        ch6_2_0();

        // 最大值最小值
//        ch6_2_1();

        // 汇总
//        ch6_2_2();

        // 连接字符串
//        ch6_2_3();

        // 广义的规约汇总
        ch6_2_4();
    }

    private static void ch6_2_4() {
        Integer ageSum = userList.stream()
                .collect(Collectors.reducing(0, User::getAge, (i, j) -> i + j));
        System.out.println(ageSum);
    }

    private static void ch6_2_3() {
        String names = userList.stream()
                .map(User::getName)
                .collect(Collectors.joining(","));
        System.out.println(names);
    }

    private static void ch6_2_2() {
        // 求和
        int ageSum = userList.stream()
                .collect(Collectors.summingInt(User::getAge));
        System.out.println(ageSum);

        // 求平均
        double ageAvg = userList.stream()
                .collect(Collectors.averagingInt(User::getAge));
        System.out.println(ageAvg);

        // 汇总的统计
        IntSummaryStatistics statistics = userList.stream()
                .collect(Collectors.summarizingInt(User::getAge));
        System.out.println(statistics);

    }

    private static void ch6_2_1() {
        Optional<User> user = userList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(User::getAge)));
        System.out.println(user.get());

        user = userList.stream()
                .collect(Collectors.minBy(Comparator.comparing(User::getAge)));
        System.out.println(user.get());
    }

    private static void ch6_2_0() {
        Long count = userList.stream()
                .collect(Collectors.counting());
        System.out.println(count);
    }

}
