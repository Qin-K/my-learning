package 算法很美.ch8贪心和动态规划.贪心;

import java.util.Scanner;

public class Test1_硬币支付 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < cnts.length; i++) {
			cnts[i] = sc.nextInt();
		}
		int n = sc.nextInt();
		int res = f(n, 5);
		System.out.println(res);
	}
	static int[] cnts = new int[6];
	static int[] coins = {1, 5, 10, 50, 100, 500};
	public static int f(int n, int cur) {
		if (n <= 0) return 0;
		int x = n / coins[cur];
		int cnt = cnts[cur];
		int t = Math.min(x, cnt);
		
		return t + f(n - coins[cur] * t, cur - 1);
	}
}
