/**
 * @author Qin Kai
 * @date 2019-11-19
 */
public class ThreadTest {
    public static void main(String[] args) {
        new Thread( () -> {
            while (true) {
                System.out.println("thread-1");
            }
        }).start();

        new Thread( () -> {
            while (true) {
                System.out.println("thread-2");
            }
        }).start();
    }
}
