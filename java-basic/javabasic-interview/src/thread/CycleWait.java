package thread;

/**
 * @author Qin Kai
 * @date 2019-11-16
 */
public class CycleWait implements Runnable {

    private static String value;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        value = "success";
    }

    public static void main(String[] args) {
        Thread t = new Thread(new CycleWait());
        t.start();
        while (value == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(value);
    }
}
