import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Qin Kai
 * @date 2019-12-10
 */
public class Test279 {
    private class Node {
        int sum;
        int depth;

        public Node(int sum, int depth) {
            this.sum = sum;
            this.depth = depth;
        }
    }
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int squre = 1;
        int diff = 3;
        while (squre <= n) {
            list.add(squre);
            squre += diff;
            diff += 2;
        }
        Queue<Node> queue = new LinkedList<>();
        for (int p : list) {
            queue.offer(new Node(p, 1));
        }
        // 用来判断当前值是否已经存在，存在过不需要重复计算，
        // 例如 9第一次出现 8 + 1，后面又出现了4 + 4 + 1不可能为最优解，不需要计算
        boolean[] marked = new boolean[n + 1];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int sum = node.sum, depth = node.depth;
            if (sum == n) {
                return depth;
            }

            for (int p : list) {
                if (sum + p > n) {
                    break;
                }
                if (marked[sum + p]) continue;
                queue.offer(new Node(sum + p, depth + 1));
                marked[sum + p] = true;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int res = new Test279().numSquares(7168);
        System.out.println(res);
    }
}
