package jvm.model;

/**
 * @author Qin Kai
 * @date 2019-11-14
 */
public class InternDifference {
    public static void main(String[] args) {
        String s = new String("a"); // 会在常量池中创建一个a，堆中也会创建一个对象值为a
        s.intern();
        String s2 = "a";
        System.out.println(s == s2);

        String s3 = new String("a") + new String("a");
        s3.intern();
        String s4 = "aa";
        System.out.println(s3 == s4);
    }
}
