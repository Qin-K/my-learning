/**
 * @author Qin Kai
 * @date 2019-12-23
 */
public class Test474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int zero = countZreo(strs[i - 1]);
            int one = strs[i - 1].length() - zero;
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j < zero || k < one) {
                        dp[i][j][k] = dp[i - 1][j][k];
                        continue;
                    }
                    dp[i][j][k] = Math.max(dp[i - 1][j][k],
                            dp[i - 1][j - zero][k - one] + 1);
                }
            }
        }
        return dp[length][m][n];
    }

    public int findMaxForm02(String[] strs, int m, int n) {
        int length = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int zero = countZreo(strs[i - 1]);
            int one = strs[i - 1].length() - zero;

            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k],
                            dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int countZreo(String s) {
        int zero = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zero++;
            }
        }
        return zero;
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
//        int res = new Test474().findMaxForm(strs, 5, 3);
        int res = new Test474().findMaxForm02(strs, 5, 3);
        System.out.println(res);
    }
}
