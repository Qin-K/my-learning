package jvm.gc;

/**
 * @author Qin Kai
 * @date 2019-11-14
 */
public class ReferenceCounterProblem {
    public static void main(String[] args) {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();

        // 循环引用
        obj1.chilNode = obj2;
        obj2.chilNode = obj1;
    }
}
