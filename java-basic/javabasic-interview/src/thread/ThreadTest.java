package thread;

/**
 * @author Qin Kai
 * @date 2019-11-16
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread() {
          @Override
          public void run() {
              System.out.println("current thread is " + Thread.currentThread().getName());
          }
        };

//        thread.run(); print main
        thread.start(); // print Thread-0 创建了子线程
    }
}
