/**
 * @author Qin Kai
 * @date 2019-12-22
 */
public class Test1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null ||
                text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 0; j < n; j++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                for (int k = j; k < n; k++) {
                    dp[0][k] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                for (int k = i; k < m; k++) {
                    dp[k][0] = 1;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public int longestCommonSubsequence01(String text1, String text2) {
        if (text1 == null || text2 == null ||
                text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
//        int res = new Test1143().longestCommonSubsequence("abcde", "ace");
        int res = new Test1143().longestCommonSubsequence01("abcde", "ace");
        System.out.println(res);
    }
}
