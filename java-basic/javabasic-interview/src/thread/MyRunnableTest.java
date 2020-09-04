package thread;

/**
 * @author Qin Kai
 * @date 2019-11-16
 */
public class MyRunnableTest {
    public static void main(String[] args) {
        MyRunnable myRunnable1 = new MyRunnable("thread1");
        MyRunnable myRunnable2 = new MyRunnable("thread2");
        MyRunnable myRunnable3 = new MyRunnable("thread3");

        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable2);
        Thread thread3 = new Thread(myRunnable3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
