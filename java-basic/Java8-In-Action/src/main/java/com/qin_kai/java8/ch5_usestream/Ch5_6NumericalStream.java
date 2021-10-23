package com.qin_kai.java8.ch5_usestream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 5.6数值流
 *
 * @author qinkai
 * @date 2021/8/19
 */
public class Ch5_6NumericalStream {

    private static class TestModel {
        int num;

        public TestModel(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
//        ch5_6_1();
//        ch5_6_2();
        ch5_6_3();
    }


    /**
     * 5.6.1原始类型流特化
     */
    private static void ch5_6_1() {
        // 映射到数值流
        List<TestModel> models = Arrays.asList(new TestModel(1), new TestModel(2), new TestModel(3));
        IntStream intStream = models.stream()
                .mapToInt(TestModel::getNum);
        // 转为对象流
//        Stream<Integer> integerStream = intStream.boxed();
        // 默认值
        OptionalInt max = intStream.max();
        System.out.println(max.orElse(0));
    }

    /**
     * 5.6.2数值范围
     */
    private static void ch5_6_2() {
        // [1, 100)的数值流
        IntStream.range(1, 100)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        // [1, 100]
        IntStream.rangeClosed(1, 100)
                .forEach(e -> System.out.print(e + " "));
    }

    /**
     * 数值流应用：勾股数
     * a*a + b*b = c*c
     */
    private static void ch5_6_3() {
        // 已知a求可能的b，c
        int a = 3;
        List<List<Integer>> gouGuList = IntStream.rangeClosed(1, 100)
                // 筛选a*a+b*b的值能够完全开方则c=sqrt(a*a+b*b)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                // IntStream的map方法只能map成另一个IntStream，所以这里boxed成Stream<Integer>
                .boxed()
                .map(b -> Arrays.asList(a, b, (int) Math.sqrt(a * a + b * b)))
                .collect(Collectors.toList());
        System.out.println(gouGuList);

        gouGuList = IntStream.rangeClosed(1, 100)
                // 筛选a*a+b*b的值能够完全开方则c=sqrt(a*a+b*b)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                // 用mapToObj方法可以直接map成一个对象流
                .mapToObj(b -> Arrays.asList(a, b, (int) Math.sqrt(a * a + b * b)))
                .collect(Collectors.toList());
        System.out.println(gouGuList);

        // a也通过遍历还实现
        List<List<List<Integer>>> result = IntStream.rangeClosed(1, 100)
                .mapToObj(a1 -> IntStream.rangeClosed(1, 100)
                        .filter(b -> Math.sqrt(a1 * a1 + b * b) % 1 == 0)
                        .mapToObj(b -> Arrays.asList(a1, b, (int) Math.sqrt(a1 * a1 + b * b)))
                        .collect(Collectors.toList()))
                .filter(list -> !list.isEmpty())
                .collect(Collectors.toList());
        System.out.println(result);

        List<List<Integer>> result2 = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a1 -> IntStream.rangeClosed(1, 100)
                        .filter(b -> Math.sqrt(a1 * a1 + b * b) % 1 == 0)
                        .mapToObj(b -> Arrays.asList(a1, b, (int) Math.sqrt(a1 * a1 + b * b))))
                .collect(Collectors.toList());
        System.out.println(result2);
    }

}
