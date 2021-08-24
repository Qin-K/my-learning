package com.qin_kai.java8.ch9_defaultmethod;

/**
 * @author qinkai
 * @date 2021/8/23
 */
public class Ch9_4ResolveConflict {

    /**
     * 实现方法比默认方法优先级高
     */
    static class Case1 {
        interface A {
            default void hello() {
                System.out.println("hello A");
            }
        }

        static class B {
            void hello() {
                System.out.println("hello B");
            }
        }

        static class C extends B implements A {
            @Override
            public void hello() {
                super.hello();
            }
        }
    }

    /**
     * 子接口的优先级更高
     */
    static class Case2 {
        interface A {
            default void hello() {
                System.out.println("hello A");
            }
        }

        interface B extends A {
            @Override
            default void hello() {
                System.out.println("hello B");
            }
        }

        static class D implements A, B {
        }
    }

    /**
     * 必须显示的覆盖这个相同的方法
     */
    static class Case3 {
        interface A {
            default void hello() {
                System.out.println("hello A");
            }
        }
        interface B {
            default void hello() {
                System.out.println("hello B");
            }
        }
        static class C implements A, B{
            @Override
            public void hello() {
                System.out.println("hello C");
            }
        }
    }

    public static void main(String[] args) {
        new Case1.C().hello();
        new Case2.D().hello();
        new Case3.C().hello();
    }

}
