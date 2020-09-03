import java.util.HashMap;
import java.util.Map;

/**
 * @author Qin Kai
 * @date 2019-11-05
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000000; i++) {
            map.put(i, i);
        }

        long time1 = System.nanoTime();

        for (int i : map.keySet()) {
            map.get(i);
        }
        long time2 = System.nanoTime();
        System.out.println("keySet: " + (time2 - time1) / 1000000000.0 + " s" );

        time1 = System.nanoTime();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            entry.getValue();
        }

        time2 = System.nanoTime();
        System.out.println("entrySet: " + (time2 - time1) / 1000000000.0 + " s" );
    }
}
