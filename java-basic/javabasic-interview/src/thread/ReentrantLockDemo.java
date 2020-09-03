package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Qin Kai
 * @date 2019-11-17
 */
public class ReentrantLockDemo implements Runnable {
    private static final ReentrantLock LOCK = new ReentrantLock(false);


    @Override
    public void run() {
        while (true) {
            try {
                LOCK.lock();
                System.out.println(Thread.currentThread().getName() + " get lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        Thread t1 = new Thread(demo, "thread-1");
        Thread t2 = new Thread(demo, "thread-2");
        t1.start();
        t2.start();
    }
}
