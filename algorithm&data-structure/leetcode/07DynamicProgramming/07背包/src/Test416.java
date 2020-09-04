/**
 * @author Qin Kai
 * @date 2019-12-22
 */
public class Test416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
//        return dfs(nums, 0, sum / 2);
        mem = new Boolean[nums.length][sum / 2 + 1];
        return dfs02(nums, 0, sum / 2);
    }

    private boolean dfs(int[] nums, int cur, int temp) {
        if (temp == 0) {
            return true;
        }
        if (temp < 0 || cur >= nums.length) {
            return false;
        }
        return dfs(nums, cur + 1, temp - nums[cur]) || dfs(nums, cur + 1, temp);
    }

    // 记忆化递归
    private Boolean[][] mem;

    private boolean dfs02(int[] nums, int cur, int temp) {
        if (temp == 0) {
            return true;
        }
        if (temp < 0 || cur >= nums.length) {
            return false;
        }
        if (mem[cur][temp] != null) {
            return mem[cur][temp];
        }
        mem[cur][temp] = dfs02(nums, cur + 1, temp - nums[cur]) || dfs02(nums, cur + 1, temp);
        return mem[cur][temp];
    }


    // dp 类似0,1背包 n个num中凑出 W(sum / 2)
    public boolean canPartition02(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int W = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][W + 1];
        for (int i = 0; i <= W; i++) {
            if (i == nums[0]) {
                dp[0][i] = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][W];
    }

    // dp 01背包空间压缩
    public boolean canPartition03(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int W = sum / 2;
        int n = nums.length;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = W; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 5};
//        boolean res = new Test416().canPartition(nums);
        boolean res = new Test416().canPartition03(nums);
        System.out.println(res);
    }
}
