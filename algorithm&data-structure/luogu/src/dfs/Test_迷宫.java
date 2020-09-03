package dfs;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Test_迷宫 {
	static int[][] graph;
	static int N;
	static int M;
	static boolean[][] vis;
	static int sX, sY;
	static int eX, eY;

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		N = sc.nextInt();
		M = sc.nextInt();
		int T = sc.nextInt();
		graph = new int[N][M];
		vis = new boolean[N][M];
		sX = sc.nextInt() - 1;
		sY = sc.nextInt() - 1;
		eX = sc.nextInt() - 1;
		eY = sc.nextInt() - 1;
		for (int i = 0; i < T; i++) {
			graph[sc.nextInt() - 1][sc.nextInt() - 1] = 1; // 障碍物
		}
		if (graph[eX][eY] == 1) {
			System.out.println(0);
			return;
		}
		dfs(sX, sY);
		System.out.println(cnt);
	}

	static int cnt;

	public static void dfs(int x, int y) {
		if (x == eX && eY == y) {
			cnt++;
			return;
		}
		if (x < 0 || x >= N || y < 0 || y >= M) return;
		if (vis[x][y]) return;
		if (graph[x][y] == 1) return;
		vis[x][y] = true;
		dfs(x - 1, y);
		dfs(x + 1, y);
		dfs(x, y - 1);
		dfs(x, y + 1);
		vis[x][y] = false;
	}
}
