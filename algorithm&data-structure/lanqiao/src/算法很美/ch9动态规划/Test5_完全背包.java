package 算法很美.ch8贪心和动态规划.动态规划;

public class Test5_完全背包 {
	static int[] v = { 9, 5, 3, 1 };
	static int[] w = { 7, 4, 3, 2 };
	static int n = 4;
	static int W = 10;
	public static void main(String[] args) {
		System.out.println(dp());
	}

	public static int dp() {
		int[][] dp = new int[n][W + 1];
		for (int i = 0; i < W + 1; i++) {
			dp[0][i] = v[0] * i / w[0];
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < W + 1; j++) {
				if (j >= w[i]) {
					dp[i][j] = Math.max(v[i] + dp[i][j - w[i]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		return dp[n - 1][W];
	}
}
