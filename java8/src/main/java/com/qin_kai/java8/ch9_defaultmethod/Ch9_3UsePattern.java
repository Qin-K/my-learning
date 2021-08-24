package com.qin_kai.java8.ch9_defaultmethod;

/**
 * 默认方法的使用模式
 *
 * @author qinkai
 * @date 2021/8/23
 */
public class Ch9_3UsePattern {

    /**
     * 可选方法
     */
    private interface Ch9_3_1 {
        interface Iterator<T> {
            boolean hasNext();

            T next();

            default void remove() {
                throw new UnsupportedOperationException();
            }
        }

    }

    /**
     * 行为的多重继承
     */
    private static class Ch9_3_2 {

        /**
         * 利用正交方法的精简接口，我感觉就是方法的实现，只需要调用接口的其他方法就能实现
         * 这种情况下，按照以前的方法，可能每个实现类都要按照实现相同的逻辑实现，或者写一个抽象类进行默认实现
         * 有了默认方法就可以在接口的默认方法中实现，这样实现类直接可以继承这个默认方法，更加简洁
         */
        interface A {
            int get();

            /**
             * 默认方法调用了接口的其他方法
             */
            default void print() {
                System.out.println("get " + get());
            }
        }

        static class A1 implements A{

            @Override
            public int get() {
                return 1;
            }
        }

        static class A2 implements A {

            @Override
            public int get() {
                return 2;
            }
        }

    }

    public static void main(String[] args) {
        new Ch9_3_2.A1().print();
        new Ch9_3_2.A2().print();
    }
}
