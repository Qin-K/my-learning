package com.qin_kai.java8.ch5_usestream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link Stream} 流的学习使用Demo
 * <p>
 * Stream流的使用分为获取流，中间操作流，终止操作
 * 获取流的操作：<br>
 * list.stream Stream.of
 * <p>
 * <p>
 * 中间操作
 * filter 过滤，通过给定的条件，过滤出流中所有符合的元素
 * limit
 * skip
 * sorted
 * <p>
 * 终止操作
 * forEach(Consumer c) 内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反， Stream API 使用内部迭代)
 * collect(Collector c) 将流转换为其他形式。接收一个Collector接口的实现，用于给流中元素做汇总的方法。
 * 查找与匹配
 * allMatch(Predicate p) 检查流中的所有元素是否都匹配指定条件
 * anyMatch(Predicate p) 检查流中是否至少一个元素匹配指定条件
 * noneMatch(Predicate p) 检查是否所有元素都不匹配指定条件
 * findFirst()
 * findAny() 返回当前流中的任意元素
 * count() 返回流中元素总数
 * max(Comparator c) 返回流中最大值
 * min(Comparator c) 返回流中最小值
 * 规约
 * reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
 * reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 筛选和切片
//        filter(list);
//        distinct();
//        limit(list);
//        skip(list);

        // 映射
//        map(list);
//        flatMap();
//        sorted();
        // 查找和匹配
//        allMatch(list);
//        anyMatch(list);
//        noneMatch(list);
//        findFirst(list);
//        findAny(list);
//        foreach(list);

//        collect(list);
//        count(list);

        // 规约
//        reduce(list);
    }

    /**
     * distinct将流中的元素进行去重
     */
    private static void distinct() {
        Stream.of(1, 1, 1, 2, 2, 3)
                .distinct()
                .forEach(e -> System.out.print(e + " "));
    }

    /**
     * flatMap主要是用来解决stream来代替双重for循环的情况
     * 比如有一个List<List<Integer>>列表，我想求出所有数的和
     * 假如流中的元素本身是list这种本身也可以转化为一个流的元素
     * 使用flatMap传入一个Function把每个元素再转为为一个流，然后flatMap会将这些流进行flat（将多个流的元素排成一个流）
     */
    private static void flatMap() {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(2, 3, 4)
        );
        list.stream()
                .flatMap(List::stream)
                .forEach(e -> System.out.print(e + " "));
    }

    private static void reduce(List<Integer> list) {
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Integer> sumOptional = list.stream()
                .reduce(Integer::sum);
        System.out.println(sumOptional.get());
    }

    private static void count(List<Integer> list) {
        long count = list.stream().count();
        System.out.println(count);
    }

    private static void findAny(List<Integer> list) {
        Optional<Integer> result = list.stream().findAny();
        System.out.println(result.get());
    }

    private static void findFirst(List<Integer> list) {
        Optional<Integer> result = list.stream().findFirst();
        System.out.println(result.get());
    }

    private static void noneMatch(List<Integer> list) {
        // list中的元素是否都不小于0
        boolean noneMatch = list.stream()
                .noneMatch(e -> e < 0);
        System.out.println(noneMatch);
    }

    private static void anyMatch(List<Integer> list) {
        // 判断list中是否包含偶数
        boolean result = list.stream()
                .anyMatch(e -> e % 2 == 0);
        System.out.println(result);
    }

    private static void allMatch(List<Integer> list) {
        // 判断list中的元素是否都小于100
        boolean result = list.stream()
                .allMatch(e -> e < 100);
        System.out.println(result);
    }

    /**
     * filter 传入Predicate（传入一个参数返回boolean类型）返回true的数据留下
     */
    private static void filter(List<Integer> list) {
        // 过滤出list中大于5的元素
        list.stream().filter((x) -> x > 5)
                .forEach(x -> System.out.print(x + " "));
    }

    /**
     * limit 元素前面n位，元素个数小于n则只返回所有元素
     */
    private static void limit(List<Integer> list) {
        // 只返回stream中前3条元素
        list.stream().limit(3).forEach(x -> System.out.print(x + " "));
    }

    /**
     * skip 跳过前面n个元素 如果元素个数小于n返回空
     */
    private static void skip(List<Integer> list) {
        // 跳过前三条元素
        list.stream().skip(3)
                .forEach(x -> System.out.print(x + " "));
    }

    /**
     * map 接受一个Function（传入一个参数，有返回），将stream的数据进行映射操作
     */
    private static void map(List<Integer> list) {
        // 将list中的元素都映射为它的平方
        list.stream().map(x -> x * x)
                .forEach(x -> System.out.print(x + " "));
    }

    /**
     * sorted 排序，自然排序/传入comparator
     */
    private static void sorted() {
        Stream.of(5, 3, 2, 4, 1, 8, 9, 7, 6, 10).sorted()
                .forEach(x -> System.out.print(x + " "));

        Stream.of(5, 3, 2, 4, 1, 8, 9, 7, 6, 10)
                .sorted((a, b) -> b - a)
                .forEach(x -> System.out.print(x + " "));
    }

    /**
     * collect通过传入一个Collector将流转化为最终的结果
     * Collectors提供了很多静态方法来获取Collector
     */
    private static void collect(List<Integer> list) {
        // Collectors.toList() 将流转化为List
        // Collectors.toSet() 和List一样
        List<Integer> numberList = list.stream().filter((x) -> x > 5)
                .collect(Collectors.toList());
        System.out.println(numberList);

        // Collectors.joining()
        // 和String的join方法，一样用于将多个元素join成一个字符串，流里面的每个元素必须是字符串类型
        String joiningResult = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(joiningResult);

        // groupingBy 类似mysql group by, 将流中的元素按照指定条件进行分组
        Map<Integer, List<Integer>> map = Stream.of(5, 3, 2, 4, 1, 8, 9, 7, 6, 10)
                .sorted()
                .collect(Collectors.groupingBy(x -> x % 2, Collectors.toList()));
        System.out.println(map);
    }

    /**
     * foreach 将流中的每个元素进行相应的操作
     */
    private static void foreach(List<Integer> list) {
        list.stream()
                .forEach(e -> System.out.print(e + " "));
    }

}
