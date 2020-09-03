package jvm.gc;

import static java.lang.Thread.*;

/**
 * @author Qin Kai
 * @date 2019-11-14
 */
public class Finalization {
    public static Finalization finalization;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize is called");
        finalization = this;
    }

    public static void main(String[] args) throws InterruptedException {
        Finalization f = new Finalization();
        System.out.println(f);
        f = null;
        System.gc();
        sleep(1000);
        System.out.println(finalization);
    }
}
