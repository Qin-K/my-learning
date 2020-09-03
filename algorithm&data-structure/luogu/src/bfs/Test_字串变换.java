package bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Test_字串变换 {
	static class Node {
		String s;
		int deep;
		public Node(String s, int deep) {
			this.s = s;
			this.deep = deep;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new HashMap<>();
		String start = sc.next();
		String end = sc.next();
		for (int i = 0; i < 3; i++) {
			map.put(sc.next(), sc.next());
			
		}
//		while (sc.hasNext()) {
//			map.put(sc.next(), sc.next());
//		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, 0));
		Set<String> set = new HashSet<>();
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			String s = node.s;
			int deep = node.deep;
			if (deep > 10) {
				System.out.println("NO ANSWER!");
				return;
			}
			
			if (s.equals(end)) {
				System.out.println(deep);
				return;
			}
			if (set.contains(s)) continue;
			set.add(s);
			for (Map.Entry<String, String> entry : map.entrySet()) {
				String k = entry.getKey();
				String v = entry.getValue();
				String ss = s;
				while (ss.contains(k)) {
					String t = ss.replaceFirst(k, v);
					queue.add(new Node(t.replace("&", k), deep + 1));
					ss = ss.replaceFirst(k, "&");
				}
			}
		}
		
		System.out.println("NO ANSWER!");
	}
}
