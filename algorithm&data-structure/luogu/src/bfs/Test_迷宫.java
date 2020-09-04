package bfs;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test_迷宫 {
	static int n;
	static char[][] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		graph = new char[n][n];
		vis = new boolean[n][n];
		for (int i = 0; i < n; i++) {
				graph[i] = sc.nextLine().toCharArray();
		}
		int[] res = new int[m];
		for (int i = 0; i < m; i++) {
			cnt = 1;
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			
			for (int j = 0; j < n; j++) {
				Arrays.fill(vis[j], false);
			}
			vis[x][y] = true;
			bfs(x, y);
			res[i] = cnt;
		}
		
		for (int i : res) {
			System.out.println(i);
		}
	}
	static int cnt;
	static boolean[][] vis;
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int nx = node.x;
			int ny = node.y;
			if (graph[nx][ny] == '0') {
				if (nx - 1 >= 0 && graph[nx - 1][ny] == '1' && !vis[nx - 1][ny]) {
					vis[nx - 1][ny] = true;
					queue.add(new Node(nx - 1, ny));
					cnt++;
				}
				if (nx + 1 < n && graph[nx + 1][ny] == '1' && !vis[nx + 1][ny]) {
					vis[nx + 1][ny] = true;
					queue.add(new Node(nx + 1, ny));
					cnt++;
				}
				if (ny - 1 >= 0 && graph[nx][ny - 1] == '1' && !vis[nx][ny - 1]) {
					vis[nx][ny - 1] = true;
					queue.add(new Node(nx, ny - 1));
					cnt++;
				}
				if (ny + 1 < n && graph[nx][ny + 1] == '1' && !vis[nx][ny + 1]) {
					vis[nx][ny + 1] = true;
					queue.add(new Node(nx, ny + 1));
					cnt++;
				}
			} else {
				if (nx - 1 >= 0 && graph[nx - 1][ny] == '0' && !vis[nx - 1][ny]) {
					vis[nx - 1][ny] = true;
					queue.add(new Node(nx - 1, ny));
					cnt++;
				}
				if (nx + 1 < n && graph[nx + 1][ny] == '0' && !vis[nx + 1][ny]) {
					vis[nx + 1][ny] = true;
					queue.add(new Node(nx + 1, ny));
					cnt++;
				}
				if (ny - 1 >= 0 && graph[nx][ny - 1] == '0' && !vis[nx][ny - 1]) {
					vis[nx][ny - 1] = true;
					queue.add(new Node(nx, ny - 1));
					cnt++;
				}
				if (ny + 1 < n && graph[nx][ny + 1] == '0' && !vis[nx][ny + 1]) {
					vis[nx][ny + 1] = true;
					queue.add(new Node(nx, ny + 1));
					cnt++;
				}
			}
		}
	}
}
