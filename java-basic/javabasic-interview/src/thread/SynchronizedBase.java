package thread;

/**
 * @author Qin Kai
 * @date 2019-11-17
 */
public class SynchronizedBase {
    public void sync1() {
        synchronized(this) {
            System.out.println("hello");
        }
    }

    public synchronized void sync2() {
        System.out.println("hello");
    }
}
