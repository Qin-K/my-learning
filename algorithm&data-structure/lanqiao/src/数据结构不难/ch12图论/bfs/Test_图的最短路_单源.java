package 数据结构不难.ch12图论.bfs;

import java.util.Arrays;

public class Test_图的最短路_单源 {
	static int[][] graph = { 
			{ 0, 2, 5, 0, 0, 0, 0 }, 
			{ 2, 0, 4, 6, 10, 0, 0 }, 
			{ 5, 4, 0, 2, 0, 0, 0 },
			{ 0, 6, 2, 0, 0, 1, 0 }, 
			{ 0, 10, 0, 0, 0, 3, 5 }, 
			{ 0, 0, 0, 1, 3, 0, 9 }, 
			{ 0, 0, 0, 0, 5, 9, 0 } 
		};
	static int[] res;

	public static void main(String[] args) {
		int n = graph.length;
		res = new int[n];
		shortestPath(0);
		System.out.println(Arrays.toString(res));
	}

	/**
	 * 求起点到各个点的最短距离
	 * 
	 * @param s
	 * @return
	 */

	public static void shortestPath(int s) {
		int n = res.length;
		for (int i = 0; i < n; i++) {
			if (i != s) {
				res[i] = Integer.MAX_VALUE;
			}
		}
		while (true) {
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if (res[i] == Integer.MAX_VALUE)
					continue;
				for (int j = 0; j < n; j++) {
					if (graph[i][j] != 0 && graph[i][j] + res[i] < res[j]) {
						res[j] = graph[i][j] + res[i];
						flag = true;
					}
				}
			}

			if (!flag)
				break;
		}
	}
}
