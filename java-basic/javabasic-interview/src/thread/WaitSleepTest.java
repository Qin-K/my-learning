package thread;

/**
 * @author Qin Kai
 * @date 2019-11-16
 */
public class WaitSleepTest {

    public static void main(String[] args) throws InterruptedException {
//        waitTest();
//        sleepTest();
        notifyTest();
    }

    public static void waitTest() throws InterruptedException {
        final Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread1 get lock");
                try {
                    lock.wait(1000); // 释放锁
                    System.out.println("Thread1 is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(10);

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread2 get lock");
                try {
                    Thread.sleep(20);
                    System.out.println("Thread2 is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void sleepTest() throws InterruptedException {
        final Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread1 get lock");
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread1 is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(10);

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread2 get lock");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2 is done");
            }
        }).start();
    }

    public static void notifyTest() throws InterruptedException {
        final Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread1 get lock");
                try {
                    lock.wait();
                    System.out.println("Thread1 is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(10);

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread2 get lock");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2 is done");
                lock.notify();
            }
        }).start();
    }
}
