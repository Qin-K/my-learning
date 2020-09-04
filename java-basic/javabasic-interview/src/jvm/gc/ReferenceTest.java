package jvm.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author Qin Kai
 * @date 2019-11-14
 */
public class ReferenceTest {
    public static void main(String[] args) {
        Object obj = new Object();
        ReferenceQueue<Object> rq = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<Object>(new Object(), rq);
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reference<?> poll = rq.poll();
        while (poll != null) {
            System.out.println(poll);
            System.out.println(poll.get());
            poll = rq.poll();
        }
    }
}
