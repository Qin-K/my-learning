package 数据结构不难.ch12图论.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import 数据结构不难.ch12图论.Edge;
import 数据结构不难.ch12图论.UnionFind;
import 数据结构不难.ch12图论.UnionFind.UFNode;

public class Kruskal {
	List<Edge> edgeList = new ArrayList<>();
	Map<String, UFNode> map = new HashMap<>();
	Set<Edge> T = new HashSet<>();
	int n;

	public Kruskal(List<Edge> edgeList, int n) {
		this.edgeList = edgeList;

		for (Edge<String> node : edgeList) {
			map.put(node.start, new UnionFind.UFNode());
			map.put(node.end, new UnionFind.UFNode());
		}
		this.n = n;
	}
	
	public Set<Edge> getT() {
		buildMST();
		return T;
	}

	private void buildMST() {
		Collections.sort(edgeList);
		for (Edge e : edgeList) {
			UFNode x = map.get(e.start);
			UFNode y = map.get(e.end);
			if (UnionFind.find(x) != UnionFind.find(y)) {
				UnionFind.Union(x, y);
				T.add(e);
				if (T.size() == n - 1) return;
			}
		}
	}

	private static List<Edge> build() {
		List<Edge> l = new ArrayList<>();
		l.add(new Edge("C", "D", 1));
		l.add(new Edge("C", "A", 1));
		l.add(new Edge("C", "E", 8));
		l.add(new Edge("A", "B", 3));
		l.add(new Edge("D", "E", 3));
		l.add(new Edge("B", "C", 5));
		l.add(new Edge("B", "E", 6));
		l.add(new Edge("B", "D", 7));
		l.add(new Edge("A", "D", 2));
		l.add(new Edge("A", "E", 9));
		return l;
	}
	
	public static void main(String[] args) {
		List<Edge> list = build();
		Kruskal kruskal = new Kruskal(list, 5);
		kruskal.buildMST();
		Set<Edge> T = kruskal.getT();
		for(Edge edge : T) {
			System.out.println(edge.start + " " + edge.end + " " + edge.distance);
		}
	}
}
