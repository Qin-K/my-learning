/**
 * @author Qin Kai
 * @date 2019-12-30
 */
public class Test123 {
    // 记忆化dfs
    public int maxProfit(int[] prices) {
        mem = new Integer[prices.length + 1][2][2];
        return dfs(prices, 0, 0, 0);
    }

    private Integer[][][] mem;

    public int dfs(int[] prices, int cur, int isBuy, int count) {
        if (count >= 2 || cur >= prices.length) {
            return 0;
        }
        if (mem[cur][isBuy][count] != null) {
            return mem[cur][isBuy][count];
        }
        int max = dfs(prices, cur + 1, isBuy, count);
        // 买
        if (isBuy == 0) {
            mem[cur][isBuy][count] = Math.max(max, dfs(prices, cur + 1, 1, count) - prices[cur]);
            return mem[cur][isBuy][count];
        }

        // 卖
        mem[cur][isBuy][count] = Math.max(max, dfs(prices, cur + 1, 0, count + 1) + prices[cur]);
        return mem[cur][isBuy][count];
    }

    // dp dp[i][k][2] leetCode题解
    // i 第i天
    // k 最大可交易数
    // 0 不持有股票，1 持有股票
    public int maxProfit02(int[] prices) {
        int n = prices.length;
        int K = 2;
        int[][][] dp = new int[n][K + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = K; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][K][0];
    }

    // dp 优化空间
    public int maxProfit03(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int dp_i10 = 0, dp_i11 = -prices[0];
        int dp_i20 = 0, dp_i21 = -prices[0];
        for (int i = 1; i < n; i++) {
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);

        }
        return dp_i20;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
//        int res = new Test123().maxProfit(prices);
//        int res = new Test123().maxProfit02(prices);
        int res = new Test123().maxProfit03(prices);
        System.out.println(res);
    }
}
