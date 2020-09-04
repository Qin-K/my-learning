import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Qin Kai
 * @date 2020-01-03
 */

class PrintRunnable implements Runnable {

    private char c;
    private int index;
    private int gap;
    private static AtomicInteger counter = new AtomicInteger(0);
    private int max = 30;

    PrintRunnable(char c, int gap, int index) {
        this.c = c;
        this.index = index;
        this.gap = gap;
    }

    @Override
    public void run() {
        while (true) {
            if (counter.get() > max - 1) break;
            if (counter.get() % gap == index) {
                System.out.println(c);
                counter.incrementAndGet();
            }
        }
    }
}

public class ConcurrentPrint {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new PrintRunnable('A', 3, 0));
        Thread threadB = new Thread(new PrintRunnable('B', 3, 1));
        Thread threadC = new Thread(new PrintRunnable('C', 3, 2));
        threadA.start();
        threadB.start();
        threadC.start();

        Thread.sleep(1000);
    }
}
