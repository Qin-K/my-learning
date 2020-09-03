package 算法很美.ch8贪心和动态规划.动态规划;

public class Test2_钢条切割 {
	static int[] v = { 1, 5, 8, 16, 10, 17, 17, 20, 24, 30 };
	static int n = 10;
	public static void main(String[] args) {
		System.out.println(dp());
	}
	
	public static int dp() {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			int max = 0;
			for (int j = 1; j <= i; j++) {
				int value = v[j - 1] + dp[i - j];
				if (value > max) max = value;
			}
			dp[i] = max;
		}
		return dp[10];
	}
}
