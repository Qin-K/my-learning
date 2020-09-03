/**
 * @author Qin Kai
 * @date 2019-12-19
 */
public class Test343 {
    // 暴力解法
    public int integerBreak1(int n) {
        if (n == 2) {
            return 1;
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * integerBreak1(n - i)));
        }
        return res;
    }

    /**
     * 记忆化搜索
     */
    private int[] memory;
    public int integerBreak2(int n) {
        if (n == 2) {
            return 1;
        }
        memory = new int[n + 1];
        memory[2] = 1;
        return dfs(n);
    }

    private int dfs(int n) {
        if (memory[n] != 0) {
            return memory[n];
        }

        int res = 0;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res,Math.max(i * (n - i), i * dfs(n - i)));
        }
        memory[n] = res;
        return res;
    }

    // dp
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i],Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
//        int res = new Test343().integerBreak1(58);
//        int res = new Test343().integerBreak2(58);
        int res = new Test343().integerBreak(58);
        System.out.println(res);
    }
}
