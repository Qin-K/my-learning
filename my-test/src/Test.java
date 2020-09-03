/**
 * @author Qin Kai
 * @date 2019-12-06
 */
public class Test {
    class A {
        public void test(){
            System.out.println("A");
        }
    }

    interface B{
        void test();
    }

    class C extends A implements B {
    }
    public static void main(String[] args) {
        new Test().new C().test();
    }
}