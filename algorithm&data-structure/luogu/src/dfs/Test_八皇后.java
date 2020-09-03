package dfs;

import java.util.Arrays;
import java.util.Scanner;

public class Test_八皇后 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		rec = new int[n + 1];
		dfs(1);
		for (int[] a : res) {
			for (int i = 1; i <= n; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
		System.out.println(cnt);
	}
	
	static int n;
	static int[] rec;
	static int[][] res = new int[3][];
	static int cnt;
	public static void dfs(int cur) {
		if (cur == n + 1) {
			if (cnt < 3) {
				res[cnt] = Arrays.copyOf(rec, n + 1);
			}
			cnt++;
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (check(cur, i)) {
				rec[cur] = i;
				dfs(cur + 1);
				rec[cur] = 0;
			}
		}
	}
	private static boolean check(int x, int y) {
		if (rec[x] != 0) return false;
		for (int i = 1; i < x; i++) {
			if (rec[i] == y) return false;
			if (i - rec[i] == x - y || i + rec[i] == x + y) return false;
		}
		return true;
	}
}
