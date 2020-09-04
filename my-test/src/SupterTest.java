/**
 * @author Qin Kai
 * @date 2019-11-17
 */
public class SupterTest {
    class A {
        private int x, y;
        public A(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public void f() {
            System.out.println("x = " + x + ", y =" + y);
        }
    }

    class B extends A {
        private int z;
        B(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }
        @Override
        public void f() {
            System.out.println("z = " + z);
            super.f();
        }
    }

    public static void main(String[] args) {
        SupterTest test = new SupterTest();
        B b = test.new B(1, 2, 3);
        b.f();
    }
}
