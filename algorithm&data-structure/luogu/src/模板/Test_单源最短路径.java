package 模板;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test_单源最短路径 {
	static class Edge {
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int st = sc.nextInt();
		int[] rec = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (i == st) {
				rec[i] = 0;
				continue;
			}
			rec[i] = Integer.MAX_VALUE;
		}
		List<Edge> list = new ArrayList<Edge>();
		for (int i = 0; i < m; i++) {
			list.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		while (true) {
			boolean flag = false;
			for (Edge e : list) {
				int u = e.u;
				int v = e.v;
				int w = e.w;
				if (rec[u] != Integer.MAX_VALUE && rec[u] + w < rec[v]) {
					rec[v] = rec[u] + w;
					flag = true;
				}
			}
			
			if (!flag) break;
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(rec[i] + " ");
		}
	}
}
