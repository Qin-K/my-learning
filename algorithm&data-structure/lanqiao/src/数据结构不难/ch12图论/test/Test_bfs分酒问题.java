package 数据结构不难.ch12图论.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Test_bfs分酒问题 {
	static Node start = new Node(0, new int[] {9, 0, 0, 0});
	static int[] a = {9, 7, 4, 2};
	static Queue<Node> queue = new LinkedList<>();
	static Set<Node> visited = new HashSet<>();
	static int[] target;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		target = new int[4];
		for (int i = 0; i < 4; i++) {
			target[i] = sc.nextInt();
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		queue.add(start);
		visited.add(start);
		Node n = null;
		int[] state = null;
		int deep = 0;
		while (!queue.isEmpty()) {
			n = queue.poll();
			state = n.state;
			deep = n.deep;
			if (Arrays.equals(state, target)) {
				return deep;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (i != j) {
						int[] help = null;
						// 给j倒满
						if (state[i] >= a[j] - state[j]) {
							help = Arrays.copyOf(state, 4);
							help[i] -= a[j] - state[j];
							help[j] = a[j];
							Node node = new Node(deep + 1,  help);
							if (!visited.contains(node)) {
								queue.add(node);
								visited.add(node);
							}
						}
						
						// 将i倒完
						if (state[i] <= a[j] - state[j]) {
							help = Arrays.copyOf(state, 4);
							help[i] = 0;
							help[j] = state[j] + state[i];
							Node node = new Node(deep + 1,  help);
							if (!visited.contains(node)) {
								queue.add(node);
								visited.add(node);
							}
						}
					}
					
				}
			}
		}
		
		return -1;
	}
	static class Node {
		int deep;
		int[] state = new int[4];
		public Node (int deep, int[] state) {
			this.deep = deep;
			this.state = state;
		}
		
		@Override
		public boolean equals(Object obj) {
			Node n = (Node)obj;
			return Arrays.equals(this.state, n.state);
		}
		
		@Override
		public int hashCode() {
			return 1;
		}
	}
}
