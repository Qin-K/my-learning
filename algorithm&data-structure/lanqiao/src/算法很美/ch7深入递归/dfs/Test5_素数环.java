package 算法很美.ch7深入递归.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class Test5_素数环 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		rec = new int[n];
		rec[0] = 1;
		dfs(1);
	}
	static int[] rec;
	static int n;
	public static void dfs(int k) {
		if (k == n && isS(rec[0] + rec[n - 1])) {
			System.out.println(Arrays.toString(rec));
			return;
		}
		for (int i = 2; i <= n; i++) {
			if (check(rec, k, i)) {
				rec[k] = i;
				dfs(k + 1);
				rec[k] = 0;
			}
		}
	}
	private static boolean check(int[] rec, int k, int i) {
		if (!isS(rec[k - 1] + i)) {
			return false;
		}
		for (int j = 1; j < n; j++) {
			if (rec[j] == i) return false;
		}
		return true;
	}
	private static boolean isS(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return false;  
		}
		return true;
	}
}
