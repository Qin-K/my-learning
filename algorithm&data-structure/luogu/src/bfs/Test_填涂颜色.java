package bfs;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test_填涂颜色 {
	static int n;
	static int[][] graph;
	static boolean[][] vis;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		n =  sc.nextInt();
		graph = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int t = sc.nextInt();
				if (t == 0) graph[i][j] = 2;
				else graph[i][j] = t;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (graph[0][i] == 2) {
				bfs(0, i);
			}
		}
		for (int i = 0; i < n; i++) {
			if (graph[n - 1][i] == 2) {
				bfs(n - 1, i);
			}
		}
		for (int i = 0; i < n; i++) {
			if (graph[i][0] == 2) {
				bfs(i, 0);
			}
		}
		for (int i = 0; i < n; i++) {
			if (graph[i][n - 1] == 2) {
				bfs(i, n - 1);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Queue<Node> queue = new LinkedList<>();
	public static void bfs(int sx, int sy) {
		Node st = new Node(sx, sy);
		queue.add(st);
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			if (graph[x][y] == 2) graph[x][y] = 0;
			if (graph[x][y] == 1) continue;
			
			if (x - 1 >= 0) queue.add(new Node(x - 1, y));
			if (x + 1 < n) queue.add(new Node(x + 1, y));
			if (y - 1 >= 0) queue.add(new Node(x, y - 1));
			if (y + 1 < n) queue.add(new Node(x, y + 1));
		}
	}
}
