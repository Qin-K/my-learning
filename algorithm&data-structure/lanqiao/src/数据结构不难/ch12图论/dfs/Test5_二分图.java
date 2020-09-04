package 数据结构不难.ch12图论.dfs;

import 数据结构不难.ch12图论.GraphNode_AL;

public class Test5_二分图 {
	public static void main(String[] args) {
		MyNode n1 = new MyNode(1);
		MyNode n2 = new MyNode(2);
		MyNode n3 = new MyNode(3);

		n1.add(n2);
		n1.add(n3);

		n2.add(n1);
		n2.add(n3);

		n3.add(n1);
		n3.add(n2);
		
		dfs(n1, 1);
		System.out.println(flag);
	}
	
	static boolean flag = false;
	public static void dfs(MyNode n, int c) {
		n.color = c;
		for (int i = 0; i < n.nexts.size(); i++) {
			MyNode node = (MyNode)n.nexts.get(i);
			if (node.color == c)  {
				flag = false;
				return;
			}
			if (node.color == 0)
				dfs(node, -c);
		}
		flag = true;
	}

	static class MyNode extends GraphNode_AL {
		int color;

		public MyNode(int val) {
			super(val);
		}

		public MyNode(int val, int c) {
			super(val);
			this.color = c;
		}
	}
}
