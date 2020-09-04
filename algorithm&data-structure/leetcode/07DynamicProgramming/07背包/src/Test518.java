/**
 * @author Qin Kai
 * @date 2019-12-26
 */
public class Test518 {
    // 完全背包
    public int change(int amount, int[] coins) {
        if (coins == null) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <=  amount; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int res = new Test518().change(3, coins);
        System.out.println(res);
    }
}
