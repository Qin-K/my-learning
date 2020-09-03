/**
 * @author Qin Kai
 * @date 2020-01-09
 */
public class Test188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        if (k > n / 2) {
            int max = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    max += prices[i] - prices[i - 1];
                }
            }
            return max;
        }
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int ki = 1; ki <= k; ki++) {
                if (i == 0) {
                    dp[i][ki][0] = 0;
                    dp[i][ki][1] = -prices[i];
                    continue;
                }
                dp[i][ki][0] = Math.max(dp[i - 1][ki][0], dp[i - 1][ki][1] + prices[i]);
                dp[i][ki][1] = Math.max(dp[i - 1][ki][1], dp[i - 1][ki - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int res = new Test188().maxProfit(2, prices);
        System.out.println(res);
    }
}
