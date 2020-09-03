/**
 * @author Qin Kai
 * @date 2019-12-18
 */
public class Test198 {
    private int max = 0;
    public int rob(int[] nums) {
        dfs(nums, 0, 0);
        return max;
    }
    // 暴力，超时
    private void dfs(int[] nums, int cur, int sum) {
        if (cur >= nums.length) {
            if (sum > max) {
                max = sum;
            }
            return;
        }
        dfs(nums, cur + 2, sum + nums[cur]);
        dfs(nums, cur + 1, sum);
    }

    // dp dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
    public int rob02(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public int rob03(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int prev2 = 0, prev1 = 0;
        for (int i = 0; i < n; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + nums[i]);
            prev2 = temp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
//        int res = new Test198().rob(nums);
        int res = new Test198().rob03(nums);
        System.out.println(res);
    }
}
