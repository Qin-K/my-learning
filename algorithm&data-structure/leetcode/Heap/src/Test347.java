import java.util.*;

/**
 * 前K个高频词
 *
 * @author Qin Kai
 * @date 2019-10-31
 */
public class Test347 {

    private class Obj {
        int e;
        int freq;

        public Obj(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Queue<Obj> pq = new PriorityQueue<>(
                (a, b) -> a.freq - b.freq
        );
        Obj obj = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            obj = new Obj(entry.getKey(), entry.getValue());
            if (pq.size() < k) {
                pq.offer(obj);
            } else if (pq.peek().freq < obj.freq) {
                pq.poll();
                pq.offer(obj);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll().e);
        }

        return list;
    }


    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        List<Integer> list = new Test347().topKFrequent(nums, 2);
        System.out.println(list);
    }
}
