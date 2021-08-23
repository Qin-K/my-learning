package com.qin_kai.java8.ch6_streamcollect;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Collector 接口
 *
 * @author qinkai
 * @date 2021/8/20
 */
public class Ch6_5CollectorInterface {


    /**
     * Collector<T,A,R>
     * T 收集的元素类型
     * A A是累加器的类型，累加器是在收集过程中用于累积部分结果的对象。
     * R是收集操作得到的对象（通常但并不一定是集合）的类型。
     */
    public static class MyToListCollector<T> implements Collector<T, List<T>, List<T>> {
        /**
         * 提供器，定义如何创建中间结果容器，返回Supplier<A>用于定义中间结果容器
         */
        @Override
        public Supplier<List<T>> supplier() {
            return ArrayList::new;
        }

        /**
         * 累加器，定义元素如何加入到中间结果容器
         * BiConsumer<A, T>，A为supplier返回的类型，T为流元素的类型
         */
        @Override
        public BiConsumer<List<T>, T> accumulator() {
            return List::add;
        }

        /**
         * 组合器，定义中间的结果容器，两个容器之间如何进行组合
         */
        @Override
        public BinaryOperator<List<T>> combiner() {
            return (list1, list2) -> {
                list1.addAll(list2);
                return list1;
            };
        }

        /**
         * 对中间结果容器，进行最终结果的转换
         */
        @Override
        public Function<List<T>, List<T>> finisher() {
            // characteristics包含IDENTITY_FINISH返回空也无所谓
//            return null;
            return list -> list;
        }

        /**
         * 定义收集器的一些特点
         * CONCURRENT 并发性，accumulator是否能并发执行
         * UNORDERED  无序性，元素不需要顺序处理
         * IDENTITY_FINISH 结果标识，定义finisher方法只是做一个标识可以省略
         */
        @Override
        public Set<Characteristics> characteristics() {
            return new HashSet<>(Arrays.asList(
                    Characteristics.UNORDERED,
                    Characteristics.CONCURRENT
//                    Characteristics.IDENTITY_FINISH
            ));
        }
    }

    public static void main(String[] args) {
        List<User> userList = Arrays.asList(
                new User(UserType.A, "testA1", 10),
                new User(UserType.A, "testA2", 20),
                new User(UserType.B, "testB1", 30),
                new User(UserType.B, "testB2", 40),
                new User(UserType.C, "testC", 50));
        List<Integer> result = userList.stream()
                .map(User::getAge)
                .collect(new MyToListCollector<>());
        System.out.println(result);


        // 通过collect方法直接自定义收集器，本质上和实现Collector感觉类似
//            <R> R collect(Supplier<R> supplier,
//                  BiConsumer<R, ? super T> accumulator,
//                  BiConsumer<R, R> combiner);
        List<String> userNames = userList.stream()
                .map(User::getName)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(userNames);
    }

}
