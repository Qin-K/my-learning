package 算法很美.ch7深入递归.dfs;

import java.util.Scanner;

public class Test4_N皇后 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		rec = new int[n];
		dfs(0);
		System.out.println(cnt);
	}
	static int n;
	static int[] rec;
	static int cnt;
	private static void dfs(int row) {
		if (row == n) {
			cnt++;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (rec[i] == j) {
						System.out.print("1");
					} else {
						System.out.print("0");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (check(row, i)) {
				rec[row] = i;
				dfs(row + 1);
				rec[row] = 0;
			}
		}
	}
	private static boolean check(int x, int y) {
		for (int i = 0; i < x; i++) {
			// 判断同列
			if (rec[i] == y) {
				return false;
			}
			
			// 判断对角线
			if (i + rec[i] == x + y || i - rec[i] == x - y) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
}
