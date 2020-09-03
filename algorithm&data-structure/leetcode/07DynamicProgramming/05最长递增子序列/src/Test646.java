import java.util.*;

/**
 * @author Qin Kai
 * @date 2019-12-20
 */
public class Test646 {
    // dfs暴力搜索，超时
    private int max;
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        dfs(pairs, 0, new ArrayList<>());
        return max;
    }

    private void dfs(int[][] pairs, int cur, List<int[]> tempList) {
        int size = tempList.size();
        if (size + pairs.length - cur < max) {
            return;
        }
        if (cur == pairs.length) {
            if (max < size) {
                max = size;
            }
            return;
        }
        int[] pair = pairs[cur];
        if (size == 0 || tempList.get(size - 1)[1] < pair[0]) {
            tempList.add(pair);
            dfs(pairs, cur + 1, tempList);
            tempList.remove(size);
        }
        dfs(pairs, cur + 1, tempList);
    }

    // dp类似递增子序列
    public int findLongestChain02(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int d : dp) {
            max = Math.max(max, d);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
//        int res = new Test646().findLongestChain(pairs);
        int res = new Test646().findLongestChain02(pairs);
        System.out.println(res);
    }
}
