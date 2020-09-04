package thread;

/**
 * @author Qin Kai
 * @date 2019-11-16
 */
public class MyThead extends Thread {
    private String name;
    public MyThead(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Current Thead is " + name + ", i = " + i);
        }
    }
}
