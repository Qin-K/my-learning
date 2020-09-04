import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Qin Kai
 * @date 2019-11-19
 */
public class ConditionTest {

    private final static ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public void before1() {
        lock.lock();
        System.out.println("before1");
        c1.signalAll();
        lock.unlock();
    }

    public void before2() {
        lock.lock();
        System.out.println("before2");
        c2.signalAll();
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest test = new ConditionTest();
        new Thread(() -> {
            lock.lock();
            try {
                test.c1.await();
                test.c2.await();
                System.out.println("my thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();
        Thread.sleep(1000);
        new Thread(() -> test.before1()).start();
        new Thread(() -> test.before2()).start();
    }
}
