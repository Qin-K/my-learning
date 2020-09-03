package 数据结构不难.ch12图论.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import 数据结构不难.ch12图论.UnionFind;
import 数据结构不难.ch12图论.UnionFind.UFNode;

public class Test_城市建设_最小生成树 {
	static class Edge implements Comparable<Edge>{
		String start;
		String end;
		int distance;
		public Edge(String start, String end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
		@Override
		public int compareTo(Edge o) {
			return this.distance - o.distance;
		}
	}
	static List<Edge> edgeList = new ArrayList<>();
	static Map<String, UFNode> map = new HashMap<>();
	static Set<Edge> set = new HashSet<>(); 
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			map.put(i + "", new UFNode());
		}
		for (int i = 0; i < m; i++) {
			edgeList.add(new Edge(sc.next(), sc.next(), sc.nextInt()));
		}
		
		for (int i = 1; i <= n; i++) {
			int c = sc.nextInt();
			if (c != -1) {
				edgeList.add(new Edge("0", i + "", c));
			}
		}
		
		buildBST();
		System.out.println(set);
		int res = 0;
		for (Edge e : set) {
			res += e.distance;
		}
		
		System.out.println(res);
	}
	
	public static void buildBST() {
		Collections.sort(edgeList);
		for (Edge e : edgeList) {
			UFNode x = map.get(e.start);
			UFNode y = map.get(e.end);
			if (UnionFind.find(x) != UnionFind.find(y)) {
				set.add(e);
				if (set.size() == n)
					return;
				UnionFind.Union(x, y);
			}
		}
	}
}
