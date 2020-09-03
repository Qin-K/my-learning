package 算法很美.ch8贪心和动态规划.动态规划;

import java.util.Scanner;

public class Test3_数字三角形 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println(dfs(a, 0, 0));
		System.out.println(dfs2(a, 0, 0));
		System.out.println(dp2(a));
	}

	public static int dfs(int[][] a, int i, int j) {
		if (i == a.length - 1)
			return a[i][j];

		return a[i][j] + Math.max(dfs(a, i + 1, j), dfs(a, i + 1, j + 1));
	}

	public static int dfs2(int[][] a, int i, int j) {
		int[][] rec = new int[a.length][a[0].length];
		if (i == a.length - 1)
			return a[i][j];
		if (rec[i][j] > 0) return rec[i][j]; 
		int ans = a[i][j] + Math.max(dfs2(a, i + 1, j), dfs2(a, i + 1, j + 1));
		rec[i][j] = ans;
		return ans;
	}
	
	public static int dp(int[][] a) {
		int n = a.length;
		int[][] dp = new int[n][n];
		// 从最后一行开始dp
		for (int i = 0; i < n; i++) {
			dp[n - 1][i] = a[n - 1][i];
		}
		
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = a[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
			}
		}
		return dp[0][0];
	}
	
	public static int dp2(int[][] a) {
		int n = a.length;
		int[] dp = new int[n];
		// 从最后一行开始dp
		for (int i = 0; i < n; i++) {
			dp[i] = a[n - 1][i];
		}
		
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = a[i][j] + Math.max(dp[j], dp[j+1]);
			}
		}
		return dp[0];
	}

}
