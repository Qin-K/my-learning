package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Qin Kai
 * @date 2019-11-16
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread t = new Thread(futureTask);
        t.start();

        if (!futureTask.isDone()) {
            System.out.println("task is running please wait..");
        }

        System.out.println("result is " + futureTask.get());
    }
}
