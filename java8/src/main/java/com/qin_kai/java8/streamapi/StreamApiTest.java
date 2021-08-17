package com.qin_kai.java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 获取stream, list.stream Stream.of
        // 中间 filter, limit, skip, sorted
        // 终止操作 查找与匹配、规约reduce、收集collect
        /*  查找与匹配
            allMatch(Predicate p) 检查是否匹配所有元素
            anyMatch(Predicate p) 检查是否至少匹配一个元素
            noneMatch(Predicate p) 检查是否没有匹配所有元素
            findFirst() 返回第一个元素
            findAny() 返回当前流中的任意元素
            count() 返回流中元素总数
            max(Comparator c) 返回流中最大值
            min(Comparator c) 返回流中最小值
            forEach(Consumer c) 内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反， Stream API 使用内部迭代)

            规约
            reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
            reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional

            收集
            collect(Collector c) 将流转换为其他形式。接收一个Collector接口的实现，用于给流中元素做汇总的方法。
            Collectors.toXXX(List Set Map) 返回一个Collector实例
        */


        // filter 传入Predicate（传入一个参数返回boolean类型）返回true的数据留下
        list.stream().filter((x) -> x > 5)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        // limit 元素前面n位，元素个数小于n则只返回所有元素
        list.stream().limit(3).forEach(x -> System.out.print(x + " "));
        System.out.println();

        // skip 跳过前面n个元素 如果元素个数小于n返回空
        list.stream().skip(3)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        // map 接受一个Function（传入一个参数，有返回），将stream的数据进行映射操作
        list.stream().map(x -> x * x)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        // sorted 排序，自然排序/传入comparator
        Stream.of(5, 3, 2, 4, 1, 8, 9, 7, 6, 10).sorted()
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        // sorted 传入comparator比较器
        Stream.of(5, 3, 2, 4, 1, 8, 9, 7, 6, 10)
                .sorted((a, b) -> b - a)
                .forEach(x -> System.out.print(x + " "));

        System.out.println();
        List<Integer> numberList = list.stream().filter((x) -> x > 5)
                .collect(Collectors.toList());
        System.out.println(numberList);

        // groupingBy, 类似mysql group by
        // 第一个参数：Function 返回结果相同的分成一组
        // 第二个参数（可省略）：每个组的操作，max min count，也可以将这个组收集起来
        // 通过groupingBy实现奇偶分组
        Map<Integer, List<Integer>> map = Stream.of(5, 3, 2, 4, 1, 8, 9, 7, 6, 10)
                .sorted()
                .collect(Collectors.groupingBy(x -> x % 2, Collectors.toList()));
        System.out.println(map);

    }
}
