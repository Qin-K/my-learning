package thread;

/**
 * @author Qin Kai
 * @date 2019-11-17
 */
public class VolatileTest {
    boolean shutdown;
//    volatile boolean shutdown;

    public void close() {
        shutdown = true;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork() {
        while (!shutdown) {
            System.out.println("safe...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest test = new VolatileTest();
        new Thread(() -> test.close()).start();
        System.out.println(test.shutdown);
        new Thread(() -> test.doWork()).start();
        new Thread(() -> test.doWork()).start();
        new Thread(() -> test.doWork()).start();
        new Thread(() -> test.doWork()).start();
    }
}
