package 数据结构不难.ch12图论;

import java.util.HashSet;
import java.util.Set;

public class UnionFind {

	public static UFNode find(UFNode x) {
		Set<UFNode> path = new HashSet<>();
		UFNode p = x;
		while (p.parent != null) {
			path.add(p);
			p = p.parent;
		}
		
		for (UFNode n : path) {
			n.parent = p;
		}
		return p;
	}
	
	public static void Union(UFNode x, UFNode y) {
		find(y).parent = find(x);
	}
	
	public static class UFNode {
		UFNode parent;
	}
}
