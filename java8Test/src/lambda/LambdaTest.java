package lambda;

import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaTest {

    @FunctionalInterface
    interface A  {
        int add(int x, int y);
    }

    public static void main(String[] args) {
        // 没有参数
        new Thread(() -> System.out.println("thread start")).start();

        // 有一个参数，无返回值， 参数可以省略括号
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("hello lambda");

        // 一个参数, 有返回值
        Function<String, Integer> function = (s) -> Integer.parseInt(s);
        System.out.println(function.apply("10"));

        // 多个参数, 有返回值，只是一句代码，省略return
        A a = (x, y) -> x + y;
        System.out.println(a.add(1, 2));

        // 多条语句，需要加上大话括号，有返回值要有return
        a = (x, y) -> {
            System.out.println(x + y);
            return x + y;
        };
        System.out.println(a.add(2, 4));
    }
}
