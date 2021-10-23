package com.qin_kai.java8.ch6_streamcollect;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 分组，Collector.groupingBy
 *
 * @author qinkai
 * @date 2021/8/19
 */
public class Ch6_3Group {

    private static final List<User> userList = Arrays.asList(
            new User(UserType.A, "testA1", 10),
            new User(UserType.A, "testA2", 20),
            new User(UserType.B, "testB1", 30),
            new User(UserType.B, "testB2", 40),
            new User(UserType.C, "testC", 50));

    public static void main(String[] args) {
        // 分组
//        ch6_3_0();

        // 多级分组
//        ch6_3_1();

        // 按子组收集数据
        ch6_3_2();
    }

    /**
     * 按子组收集数据，感觉这个很像sql中的group然后聚合，第一个参数表示以那个字段进行group，第二个参数表示聚合(max,min,avg,sum)
     */
    private static void ch6_3_2() {
        Map<UserType, Long> countByType = userList.stream()
                .collect(Collectors.groupingBy(User::getUserType, Collectors.counting()));
        System.out.println(countByType);
        Map<UserType, Integer> sumByType = userList.stream()
                .collect(Collectors.groupingBy(User::getUserType, Collectors.summingInt(User::getAge)));
        System.out.println(sumByType);

        // 将收集器的结果转化为另一种类型
        // Collectors.collectingAndThen接受一个收集器和一个Function接口
        // 第一个收集器产生结果，第二个参数将收集器的结果进行转化
        int result = userList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        System.out.println(result);

        Optional<User> maxAgeUserOptional = userList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(User::getAge)));
        System.out.println(maxAgeUserOptional.get());

        // 结果为Optional通过collectingAndThen调用Optional#get方法去除包裹
        User maxAgeUser = userList.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(User::getAge)),
                        Optional::get));
        System.out.println(maxAgeUser);
    }

    private static void ch6_3_1() {
        // 一级分组按照UserType，二级分组按照age分组
        Map<UserType, Map<Integer, List<User>>> usersByTypeAndAge = userList.stream()
                .collect(Collectors.groupingBy(User::getUserType,
                        Collectors.groupingBy(user -> {
                            if (user.getAge() <= 20) {
                                return 1;
                            } else if (user.getAge() <= 40) {
                                return 2;
                            } else {
                                return 3;
                            }
                        })));
        System.out.println(usersByTypeAndAge);
    }

    private static void ch6_3_0() {
        Map<UserType, List<User>> usersByType = userList.stream()
                .collect(Collectors.groupingBy(User::getUserType));
        System.out.println(usersByType);

        // 按年龄分组 1(0,20]，2(20-40]，3(40，Max)
        Map<Integer, List<User>> usersByAge = userList.stream()
                .collect(Collectors.groupingBy(user -> {
                    if (user.getAge() <= 20) {
                        return 1;
                    } else if (user.getAge() <= 40) {
                        return 2;
                    } else {
                        return 3;
                    }
                }));
        System.out.println(usersByAge);
    }

}
