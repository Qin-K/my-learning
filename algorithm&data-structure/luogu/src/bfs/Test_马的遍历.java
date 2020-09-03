package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Test_马的遍历 {
	static class Node {
		int x, y, deep;
		public Node(int x, int y, int deep) {
			this.x = x;
			this.y = y;
			this.deep = deep;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] board = new int[n][m];
		int sx = sc.nextInt() - 1, sy = sc.nextInt() - 1;
		Node st = new Node(sx, sy, 0);
		Queue<Node> queue = new LinkedList<>();
		queue.add(st);
		Set<String> set = new HashSet<>();
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x, y = node.y, deep = node.deep;
			if (set.contains(x + "," + y)) continue;
			set.add(x + "," + y);
			if (board[x][y] == 0) {
				board[x][y] = deep;
			}
			if (x - 1 >= 0 && y + 2 < m) {
				queue.add(new Node(x - 1, y + 2, deep + 1));
			}
			if (x - 1 >= 0 && y - 2 >= 0) {
				queue.add(new Node(x - 1, y - 2, deep + 1));
			}
			if (x + 1 < n && y + 2 < m) {
				queue.add(new Node(x + 1, y + 2, deep + 1));
			}
			if (x + 1 < n && y - 2 >= 0) {
				queue.add(new Node(x + 1, y - 2, deep + 1));
			}
			
			if (x - 2 >= 0 && y + 1 < m) {
				queue.add(new Node(x - 2, y + 1, deep + 1));
			}
			if (x + 2 < n && y + 1 < m) {
				queue.add(new Node(x + 2, y + 1, deep + 1));
			}
			if (x - 2 >= 0 && y - 1 >= 0) {
				queue.add(new Node(x - 2, y - 1, deep + 1));
			}
			if (x + 2 < n && y -1 >= 0) {
				queue.add(new Node(x + 2, y - 1, deep + 1));
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0 && !(i == sx && j == sy)) {
					System.out.printf("%-5d", -1);
				} else {
					System.out.printf("%-5d", board[i][j]);
				}
			}
			System.out.println();
		}
	}
}
