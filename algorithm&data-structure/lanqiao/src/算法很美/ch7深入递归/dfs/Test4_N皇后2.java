package 算法很美.ch7深入递归.dfs;

import java.util.Scanner;

public class Test4_N皇后2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		rec = new int[n][n];
		dfs(0);
		System.out.println(cnt);
	}
	static int n;
	static int[][] rec;
	static int cnt;
	private static void dfs(int row) {
		if (row == n) {
			cnt++;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(rec[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (check(row, i)) {
				rec[row][i] = 1;
				dfs(row + 1);
				rec[row][i] = 0;
			}
		}
	}
	private static boolean check(int x, int y) {
		for (int i = 0; i < x; i++) {
			// 判断同列
			if (rec[i][y] == 1) return false;
			
			// 判断对角线
			for (int j = x - 1, k = y - 1; j >= 0 && k >= 0; j--, k--) {
				if (rec[j][k] == 1) return false;
			}
			
			for (int j = x - 1, k = y + 1; j >= 0 && k < n; j--, k++) {
				if (rec[j][k] == 1) return false;
			}
		}
		return true;
	}
	
	
	
	
}
