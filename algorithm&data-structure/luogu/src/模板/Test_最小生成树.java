package 模板;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Test_最小生成树 {
	static class Edge implements Comparable<Edge> {
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static int[] father = new int[5005];
	static Set<Integer> path = new HashSet<>();
	public static int find(int x) {
		path.clear();
		while (father[x] != 0) {
			path.add(x);
			x = father[x];
		}
		
		for (int n : path) {
			father[n] = x;
		}
		
		return x;
	}
	public static void union(int x, int y) {
		father[find(y)] = find(x);
	}
	public static int buildMST(List<Edge> edgeList) {
		Collections.sort(edgeList);
		int cnt = 0;
		int min = 0;
		for (Edge e : edgeList) {
			int u = e.u;
			int v = e.v;
			int w = e.w;
			int x = find(u);
			int y = find(v);
			if (x != y) {
				union(x, y);
				min += w;
				cnt++;
			}
			if (cnt == n - 1) return min;
		}
		
		return 0;
	}
	
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		n = sc.nextInt();
		int m = sc.nextInt();
		
		List<Edge> edgeList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			edgeList.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		int min = buildMST(edgeList);
		if (min == 0) {
			System.out.println("orz");
			return;
		}
		System.out.println(min);
	}
}
