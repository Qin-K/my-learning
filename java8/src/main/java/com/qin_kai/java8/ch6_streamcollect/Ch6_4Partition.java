package com.qin_kai.java8.ch6_streamcollect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分区，Collectors.partitionBy
 * 感觉partitionBy就是groupingBy的特殊例子（按照一个Boolean值true/false划分）
 *
 * @author qinkai
 * @date 2021/8/19
 */
public class Ch6_4Partition {

    private static final List<User> userList = Arrays.asList(
            new User(true, "male1"),
            new User(true, "male2"),
            new User(false, "female1"),
            new User(false, "female2"));

    public static void main(String[] args) {
        ch6_4_0();
    }

    private static void ch6_4_0() {
        Map<Boolean, List<User>> usersByGender = userList.stream()
                .collect(Collectors.partitioningBy(User::isMale));
        System.out.println(usersByGender);

        usersByGender = userList.stream()
                .collect(Collectors.groupingBy(User::isMale));
        System.out.println(usersByGender);
    }
}
