/**
 * @author Qin Kai
 * @date 2019-12-27
 */
public class Test309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] sell = new int[n];
        int[] buy = new int[n];
        int[] cool = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            sell[i] = Math.max(buy[i - 1]+ prices[i], cool[i - 1]);
            buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
            cool[i] = Math.max(sell[i - 1], cool[i - 1]);
        }
        return Math.max(sell[n - 1], cool[n - 1]);
    }
    // dp leetCode题解
    public int maxProfit02(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int dp_i0 = 0, dp_i1 = -prices[0];
        int dp_pre0 = 0;
        for (int i = 1; i < n; i++) {
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, dp_pre0 - prices[i]);
            dp_pre0 = temp;
        }
        return dp_i0;
    }


    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        int res = new Test309().maxProfit(prices);
        System.out.println(res);
    }
}
