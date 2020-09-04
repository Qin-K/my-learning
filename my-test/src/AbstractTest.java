/**
 * @author Qin Kai
 * @date 2019-12-06
 */
interface  A {
    public static void  hello() {
        System.out.println("hello");
    }

    default void hi() {

    }
}

//public class MyStr extends String {
//
//}

public abstract class AbstractTest {

    public static void main(String[] args) {
        A.hello();
    }
}
