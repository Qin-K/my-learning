/**
 * @author Qin Kai
 * @date 2019-11-17
 */
public class AbstractAndInterfaceTest {

    abstract class Cls {
        private void fun() {

        }
    }

    interface A {
        default void fun(){};
    }

    interface B {
        void fun();
    }

    class C {
        void fun() {

        }
    }

    class D implements A, B {

        @Override
        public void fun() {

        }
    }

    class E extends C implements A {

        @Override
        public void fun() {

        }
    }

    public static void main(String[] args) {

    }
}
