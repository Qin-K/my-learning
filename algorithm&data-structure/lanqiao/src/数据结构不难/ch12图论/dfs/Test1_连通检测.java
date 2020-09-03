package 数据结构不难.ch12图论.dfs;

import java.util.Scanner;

public class Test1_连通检测 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		graph = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			graph[i] = sc.nextLine().toCharArray();
		}
		
		int M = sc.nextInt();
		boolean[] res = new boolean[M];
		for (int i = 0; i < M; i++) {
			points[0] = sc.nextInt();
			points[1] = sc.nextInt();
			points[2] = sc.nextInt();
			points[3] = sc.nextInt();
			flag = false;
			dfs();
			res[i] = flag;
		}
		
		for (int i = 0; i < M; i++) {
			System.out.println(res[i]);
		}
	}
	static char[][] graph;
	static int[] points = new int[4];
	static boolean flag;
	static boolean[][] visited;
	public static void dfs() {
		int x1 = points[0];
		int y1 = points[1];
		int x2 = points[2];
		int y2 = points[3];
		
		if (x1 == x2 && y1 == y2) {
			flag = true;
			return;
		}
		visited[x1][y1] = true;
		int value = graph[x1][y1];
		int N = graph.length;
		// 上
		if (x1 - 1 >= 0 && !visited[x1 - 1][y1] && graph[x1 - 1][y1] == value) {
			points[0]--;
			dfs();
			points[0]++;
		}
		// 下
		if (x1 + 1 < N && !visited[x1 + 1][y1] && graph[x1 + 1][y1] == value) {
			points[0]++;
			dfs();
			points[0]--;
		}
		// 左
		if (y1 - 1 >= 0 && !visited[x1][y1 - 1] && graph[x1][y1 - 1] == value) {
			points[1]--;
			dfs();
			points[1]++;
		}
		// 右
		if (y1 + 1 < N && !visited[x1][y1 + 1] && graph[x1][y1 + 1] == value) {
			points[1]++;
			dfs();
			points[1]--;
		}
		visited[x1][y1] = false;
	}
}
