/**
 * @author Qin Kai
 * @date 2019-12-06
 */
public class Test121 {
    // bad
    public int maxProfit01(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    // bad
    public int maxProfit02(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int[] minArr = new int[prices.length];
        int[] maxArr = new int[prices.length];
        int min = minArr[0] =  prices[0];
        int max = maxArr[prices.length - 1] = prices[prices.length - 1];
        maxArr[prices.length - 1] = max;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }

            if (prices[prices.length - 1 - i] > max) {
                max = prices[prices.length - 1 - i];
            }
            minArr[i] = min;
            maxArr[prices.length - 1 - i] = max;
        }

        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (maxArr[i] - minArr[i] > res) {
                res = maxArr[i] - minArr[i];
            }
        }

        return res;
    }


    public int maxProfit03(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int sofarMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - sofarMin;
            if (temp > maxProfit) {
                maxProfit = temp;
            }
            if (prices[i] < sofarMin ) {
                sofarMin = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int res = new Test121().maxProfit01(prices);
//        int res = new Test121().maxProfit02(prices);
        int res = new Test121().maxProfit03(prices);
        System.out.println(res);
    }
}
