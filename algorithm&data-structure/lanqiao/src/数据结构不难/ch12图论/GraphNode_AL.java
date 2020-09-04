package 数据结构不难.ch12图论;

import java.util.ArrayList;
import java.util.List;

// 图的邻接表表示
public class GraphNode_AL {
	public int val;
	public List<GraphNode_AL> nexts = new ArrayList<>();
	
	public GraphNode_AL(int val) {
		this.val = val;
	}
	
	public void add(GraphNode_AL node) {
		nexts.add(node);
	}
}
