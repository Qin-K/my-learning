/**
 * @author Qin Kai
 * @date 2019-12-18
 */
public class Test70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairs02(int n) {
        int p1 = 1, p2 = 1;
        int cur;
        for (int i = 2; i <= n; i++) {
            cur = p1 + p2;
            p1 = p2;
            p2 = cur;
        }
        return p2;
    }

    public static void main(String[] args) {
//        int res = new Test70().climbStairs(4);
        int res = new Test70().climbStairs02(4);
        System.out.println(res);
    }
}
