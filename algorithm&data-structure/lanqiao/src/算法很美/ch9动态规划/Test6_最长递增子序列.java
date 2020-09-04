package 算法很美.ch8贪心和动态规划.动态规划;

import java.util.ArrayList;
import java.util.List;

public class Test6_最长递增子序列 {
	public static void main(String[] args) {
		int[] arr = { 4, 2, 3, 1, 5, 6, 4, 8, 5, 9 };
		System.out.println(dp(arr));
		System.out.println(dp1(arr));
	}

	private static int dp1(int[] arr) {
		int n = arr.length;
		List<Integer> dp = new ArrayList<>();
		dp.add(arr[0]);
		for (int i = 1; i < n; i++) {
			if (dp.get(dp.size() - 1) < arr[i]) {
				dp.add(arr[i]);
				continue;
			}
			for (int j = 0; j < dp.size(); j++) {
				if (dp.get(j) > arr[i]) {
					dp.set(j, arr[i]);
					break;
				}
			}

		}
		System.out.println(dp);
		return dp.size();
	}

	private static int dp(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		dp[0] = 1;
		int maxCnt = 1;
		for (int i = 1; i < n; i++) {
			int tempMax = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i]) {
					if (dp[j] + 1 >= tempMax)
						tempMax = dp[j] + 1;
				}
			}
			dp[i] = tempMax;
			if (tempMax > maxCnt)
				maxCnt = tempMax;
		}
		return maxCnt;
	}

}
