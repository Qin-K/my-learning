/**
 * @author Qin Kai
 * @date 2019-12-31
 */
public class Test122 {
    // 1 2 3 最大 2-1 + 3-2
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    // dp
    public int maxProfit02(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int dp_i0 = 0, dp_i1 = -prices[0];
        for (int i = 1; i < n; i++) {
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, temp - prices[i]);
        }
        return dp_i0;
    }
}
