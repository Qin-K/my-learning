package dfs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Test_单词方阵 {
	static int n;
	static char[][] graph;
	static char[] s = "yizhong".toCharArray();
	static int[] T = {1, 2, 3, 4, 5, 6, 7, 8}; // 8个方向
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		n = sc.nextInt();
		graph = new char[n][];
		rec = new Node[7];
		for (int i = 0; i < 7; i++) {
			rec[i] = new Node();
		}
		g = new int[n][n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			graph[i] = sc.nextLine().toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 1; k <= 8; k++) {
					if (graph[i][j] == 'y') {
						dfs(i, j, 0, k);
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j] != 1) {
					System.out.print("*");
				} else {
					System.out.print(graph[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	static int cnt;
	static Node[] rec; // 记录位置
	static int[][] g; 
	static class Node {
		int x;
		int y;
	}
	public static void dfs(int x, int y, int cur, int t) {
		if (cur == 7) {
			cnt++;
			for (int i = 0; i < rec.length; i++) {
				g[rec[i].x][rec[i].y] = 1;
			}
			return;
		}
		if (x < 0 || x >= n || y < 0 || y >= n) {
			return;
		}
		if (graph[x][y] != s[cur]) {
			return;
		}
		if (t == 1) { // 1
			rec[cur].x = x;
			rec[cur].y = y;
			dfs(x - 1, y, cur + 1, t);
		}
		if (t == 2) { // 2
			rec[cur].x = x;
			rec[cur].y = y;
			dfs(x - 1, y + 1, cur + 1, t);
		}
		if (t == 3) { // 3
			rec[cur].x = x;
			rec[cur].y = y;
			dfs(x, y + 1, cur + 1, t);
		}
		if (t == 4) { // 4
			rec[cur].x = x;
			rec[cur].y = y;
			dfs(x + 1, y + 1, cur + 1, t);
		}
		if (t == 5) { // 5
			rec[cur].x = x;
			rec[cur].y = y;
			dfs(x + 1, y, cur + 1, t);
		}
		if (t == 6) { // 6
			rec[cur].x = x;
			rec[cur].y = y;
			dfs(x + 1, y - 1, cur + 1, t);
		}
		if (t == 7) { // 7
			rec[cur].x = x;
			rec[cur].y = y;
			dfs(x, y - 1, cur + 1, t);
		}
		if (t == 8) { // 8
			rec[cur].x = x;
			rec[cur].y = y;
			dfs(x - 1, y - 1, cur + 1, t);
		}
	}
}
