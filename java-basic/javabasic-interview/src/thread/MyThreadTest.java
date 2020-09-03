package thread;

/**
 * @author Qin Kai
 * @date 2019-11-16
 */
public class MyThreadTest {
    public static void main(String[] args) {
        MyThead myThead1 = new MyThead("thread1");
        MyThead myThead2 = new MyThead("thread2");
        MyThead myThead3 = new MyThead("thread3");
        myThead1.start();
        myThead2.start();
        myThead3.start();
    }
}
