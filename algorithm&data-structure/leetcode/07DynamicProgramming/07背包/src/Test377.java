/**
 * @author Qin Kai
 * @date 2019-12-27
 */
public class Test377 {
    public int combinationSum4(int[] nums, int target) {
        mem = new Integer[target + 1];
        return dfs(nums, target);
    }

    private Integer[] mem;
    private int dfs(int[] nums, int target) {
        if (target < 0) return 0;
        if (target == 0) {
            return 1;
        }
        if (mem[target] != null) {
            return mem[target];
        }
        int ret = 0;
        for (int num : nums) {
            ret += dfs(nums, target - num);
        }
        mem[target] = ret;
        return ret;
    }

    // dp
    public int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        int res = new Test377().combinationSum4(nums, 4);
        int res = new Test377().combinationSum4_2(nums, 4);
        System.out.println(res);
    }
}
