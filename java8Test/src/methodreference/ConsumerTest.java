package methodreference;

import java.util.function.Consumer;

/**
 * @author qinkai
 * @date 2020-07-10 14:42:12
 * @description
 **/
public class ConsumerTest {
    public void test(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("hello world");

        consumer = new ConsumerTest()::test;
        consumer.accept("hello world");
    }
}
