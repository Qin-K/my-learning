import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Qin Kai
 * @date 2019-12-09
 */
public class CompareListTest {
    public long addTest(List<Integer> list, int opCount) {
        long time1 = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            list.add(new Random().nextInt());
        }
        long time2 = System.nanoTime();
        return (time2 - time1) / 1000000000;
    }

    public long traversalTest(List<Integer> list, int opCount) {
        addTest(list, opCount);
        long time1 = System.nanoTime();
        for (int i : list) {
        }
        long time2 = System.nanoTime();
        return (time2 - time1) / 1000000000;
    }

    public static void main(String[] args) {
        int opCount = 100000000;
        CompareListTest test = new CompareListTest();
//        long time = test.addTest(new ArrayList<>(), opCount);
//        System.out.println("array list add: " + time + " s");
//
//        time = test.addTest(new LinkedList<>(), opCount);
//        System.out.println("linked list add: " + time + " s");
        long time = test.traversalTest(new ArrayList<>(), opCount);
        System.out.println("array list traversal: " + time + " s");

        time = test.traversalTest(new LinkedList<>(), opCount);
        System.out.println("linked list traversal: " + time + " s");
    }


}
