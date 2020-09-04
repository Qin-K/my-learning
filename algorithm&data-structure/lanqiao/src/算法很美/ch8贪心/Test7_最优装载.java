package 算法很美.ch8贪心和动态规划.贪心;

import java.util.Arrays;
import java.util.Scanner;

public class Test7_最优装载 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
		}
		
		int c = sc.nextInt();
		int res = f(w, c);
		System.out.println(res);
	}

	private static int f(int[] w, int c) {
		Arrays.sort(w);
		int cnt = 0;
		int s = 0;
		for (int i = 0; i < w.length; i++) {
			s += w[i];
			if (s <= c) {
				cnt++;
			} else {
				break;
			}
		}
		return cnt;
	}
}
