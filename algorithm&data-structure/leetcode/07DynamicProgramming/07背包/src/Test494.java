import java.util.HashMap;
import java.util.Map;

/**
 * @author Qin Kai
 * @date 2019-12-23
 */
public class Test494 {

    public int findTargetSumWays(int[] nums, int S) {
//        return dfs(nums, 0, S);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum) return 0;
        return dfs02(nums, 0, S);
    }
    // 暴力dfs
    private int dfs(int[] nums, int cur, int S) {
        if (cur == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return dfs(nums, cur + 1, S + nums[cur]) +
                dfs(nums, cur + 1, S - nums[cur]);
    }

    // 记忆化递归
    private Map<String, Integer> mem = new HashMap<>();
    private int dfs02(int[] nums, int cur, int S) {
        if (cur == nums.length) {
            return S == 0 ? 1 : 0;
        }
        String key = cur + "&" + S;
        if (mem.get(key)!= null) {
            return mem.get(key);
        }
        mem.put(key, dfs02(nums, cur + 1, S + nums[cur]) +
                dfs02(nums, cur + 1, S - nums[cur]));
        return mem.get(key);
    }

    // dp
    // 将nums分为P（正数）和N（负数）
    // sum(P) - sum(N) = S
    // sum(p) + sum(N) + sum(P) - sum(N) = S + sum(P) + sum(N);
    // 2sum(P) = S + sum(nums) => sum(P) = (S + sum(nums)) / 2
    // 及存在一个子集P使得，sum(P) == (S + sum(nums)) / 2存在，01背包问题
    public int findTargetSumWays02(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || (sum + S) % 2 != 0) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = W; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1,1,1,1};
        int res = new Test494().findTargetSumWays(nums, 3);
//        int res = new Test494().findTargetSumWays02(nums, 3);
        System.out.println(res);
    }
}
