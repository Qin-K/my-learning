package 算法很美.ch8贪心和动态规划.贪心;

import java.util.Arrays;

public class Test9_乘船问题 {
	public static void main(String[] args) {
		int[] w = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int c = 10;

		int res = f(w, c);
		System.out.println(res);
	}

	private static int f(int[] w, int c) {
		Arrays.sort(w);
		int cnt = 0;
		int n = w.length;
		int p1 = 0;
		int p2 = n - 1;
		while (p1 <= p2) {
			if (w[p1] + w[p2] <= c) {
				cnt++;
				p1++;
				p2--;
			} else {
				p2--;
				cnt++;
			}
		}

		return cnt;
	}

}
