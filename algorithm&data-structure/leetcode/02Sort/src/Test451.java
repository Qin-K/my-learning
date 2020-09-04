import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Qin Kai
 * @date 2019-12-03
 */
public class Test451 {

    private class Pair {
        char c;
        int freq;

        public Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public String frequencySort01(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length();i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Pair> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }

        list.sort((p1, p2) -> {
            return p2.freq - p1.freq;
        });


        StringBuilder sb = new StringBuilder();
        for (Pair p : list) {
            for (int i = 0; i < p.freq; i++) {
                sb.append(p.c);
            }
        }

        return sb.toString();
    }

    public String frequencySort02(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length();i++) {
            int t = map.getOrDefault(s.charAt(i), 0) + 1;
            if (t > max) {
                max = t;
            }
            map.put(s.charAt(i), t);
        }

        List<Character>[] record = new ArrayList[max + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();
            if (record[freq] == null) {
                record[freq] = new ArrayList<>();
            }
            record[freq].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = max; i >= 1; i--) {
            if (record[i] == null) {
                continue;
            }
            for (char c : record[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String res = new Test451().frequencySort01("abaacc");
        String res = new Test451().frequencySort02("abaacc");
        System.out.println(res);
    }
}
