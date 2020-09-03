package 算法很美.ch8贪心和动态规划.动态规划;

import java.util.ArrayList;
import java.util.List;

public class Test4_最长公共子序列 {
	public static void main(String[] args) {
		System.out.println(dfs("3069248", "513164318"));
		System.out.println(dp("3069248", "513164318"));
	}
	
	// dfs的方法
	public static List<Character> dfs(String s1, String s2) {
		List<Character> res = new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) {
			List<Character> temp = new ArrayList<>();
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					temp.add(s1.charAt(i));
					temp.addAll(dfs(s1.substring(i + 1, s1.length()), s2.substring(j + 1, s2.length())));
					break;
				}
			}
			
			if (temp.size() > res.size()) {
				res = temp;
			}
		}
		return res;
	}
	
	public static int dp(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length();
		int[][] dp = new int[n2][n1];
		
		// 初始化第一行
		for (int i = 0; i < n1; i++) {
			if (s1.charAt(i) == s2.charAt(0)) {
				for (int j = i; j < n1; j++) {
					dp[0][j] = 1;
				}
				break;
			}
		}
		
		// 初始化第一列
		for (int i = 0; i < n2; i++) {
			if (s2.charAt(i) == s1.charAt(0)) {
				for (int j = i; j < n2; j++) {
					dp[j][0] = 1;
				}
				break;
			}
		}
		
		// dp
		for (int i = 1; i < n2; i++) {
			for (int j = 1; j < n1; j++) {
				if (s1.charAt(j) == s2.charAt(i)) {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		
		return dp[n2 - 1][n1 - 1];
	}
	
}
