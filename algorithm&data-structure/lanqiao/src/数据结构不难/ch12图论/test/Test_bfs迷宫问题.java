package 数据结构不难.ch12图论.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test_bfs迷宫问题 {
	static char[][] graph;
	static int n;
	static int m;
	static Queue<Node> queue = new LinkedList<>();
	static boolean[][] vis;

	public static void main(String[] args) {
		n = 21;
		m = 32;
		graph = new char[n][m];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			graph[i] = sc.nextLine().toCharArray();
		}

		vis = new boolean[n][m];
		int res = bfs();
		System.out.println(res);
	}

	public static int bfs() {
		Node start = new Node(0, 0, 0);
		queue.add(start);
		int res = -1;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			int deep = node.deep;
			vis[x][y] = true;
			if (x == n - 1 && y == m - 1) {
				return deep;
			}
			// 上
			if (x - 1 >= 0 && !vis[x - 1][y] && graph[x - 1][y] == '.') {
				queue.add(new Node(x - 1, y, deep + 1));
			}
			// 下
			if (x + 1 < n && !vis[x + 1][y] && graph[x + 1][y] == '.') {
				queue.add(new Node(x + 1, y, deep + 1));
			}
			// 左
			if (y - 1 >= 0 && !vis[x][y - 1] && graph[x][y - 1] == '.') {
				queue.add(new Node(x, y - 1, deep + 1));
			}
			// 右
			if (y + 1 < m && !vis[x][y + 1] && graph[x][y + 1] == '.') {
				queue.add(new Node(x, y + 1, deep + 1));
			}
		}
		
		return res;
	}

	static class Node {
		int x;
		int y;
		int deep;

		public Node(int x, int y, int deep) {
			this.x = x;
			this.y = y;
			this.deep = deep;

		}
	}
}
