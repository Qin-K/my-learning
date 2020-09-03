/**
 * @author Qin Kai
 * @date 2019-12-30
 */
public class Test121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sofarMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - sofarMin > maxProfit) {
                maxProfit = prices[i] - sofarMin;
            }
            if (prices[i] < sofarMin) {
                sofarMin = prices[i];
            }
        }
        return maxProfit;
    }
    // dp
    public int maxProfit02(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // dp k = 1
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 10, 4, 5};
        int res = new Test121().maxProfit(prices);
        System.out.println(res);
    }
}
