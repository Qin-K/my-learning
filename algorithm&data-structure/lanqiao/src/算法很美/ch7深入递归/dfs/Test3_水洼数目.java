package 算法很美.ch7深入递归.dfs;

import java.util.Scanner;

public class Test3_水洼数目 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] a = new char[n][m];
		for (int i = 0; i < n; i++) {
			a[i] = sc.next().toCharArray(); 
		}
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 'W') {
					dfs(a, i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

	private static void dfs(char[][] a, int i, int j) {
		if (i < 0 || i >= a.length || j < 0 || j >= a[0].length) return;
		if (a[i][j] != 'W') return; 
		a[i][j] = '.';
		
		for (int r = -1; r <= 1; r++) {
			for (int c = -1; c <= 1; c++) {
				if (r == 0 && c == 0) continue;
				dfs(a, i + r, j + c);
			}
		}
	}
}
