package thread;

import java.util.concurrent.Callable;

/**
 * @author Qin Kai
 * @date 2019-11-16
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("task is runing");
        Thread.sleep(5000);
        System.out.println("task is done");
        return "success";
    }
}
