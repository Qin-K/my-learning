/**
 * @author Qin Kai
 * @date 2019-12-19
 */
public class Test91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;
        if (len == 1) {
            return dp[0];
        }
        if (s.charAt(1) != '0') {
            dp[1] = dp[0];
        }
        if (Integer.parseInt(s.substring(0, 2)) <= 26) {
            dp[1] += 1;
        }
        for (int i = 2; i < len; i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }
            if (s.charAt(i - 1) != '0' &&
                    Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int res = new Test91().numDecodings("226");
        System.out.println(res);
    }
}
