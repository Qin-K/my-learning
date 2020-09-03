import java.util.Arrays;

/**
 * @author Qin Kai
 * @date 2019-12-18
 */
public class Test62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1;i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }
    public int uniquePaths02(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1;i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[j]为 i - 1,j及上一行的结果
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
//        int res = new Test62().uniquePaths(3, 2);
        int res = new Test62().uniquePaths02(3, 2);
        System.out.println(res);
    }
}
