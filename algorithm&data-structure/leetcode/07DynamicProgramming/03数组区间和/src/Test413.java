/**
 * @author Qin Kai
 * @date 2019-12-19
 */
public class Test413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i -1] + 1;
            }
        }

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            cnt += dp[i];
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int res = new Test413().numberOfArithmeticSlices(A);
        System.out.println(res);
    }
}
