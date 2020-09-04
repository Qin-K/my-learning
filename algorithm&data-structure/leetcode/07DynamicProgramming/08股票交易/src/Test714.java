/**
 * @author Qin Kai
 * @date 2019-12-27
 */
public class Test714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[n - 1];
    }

    // leetCode dp题解
    public int maxProfit02(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int dp_i0 = 0, dp_i1 = -prices[0] - 2;
        for (int i = 1; i < n; i++) {
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, temp - prices[i] - fee);
        }
        return dp_i0;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
//        int res = new Test714().maxProfit(prices, 2);
        int res = new Test714().maxProfit02(prices, 2);
        System.out.println(res);
    }
}
