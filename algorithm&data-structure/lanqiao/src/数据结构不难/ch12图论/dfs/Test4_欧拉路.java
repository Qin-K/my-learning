package 数据结构不难.ch12图论.dfs;

import java.util.ArrayList;
import java.util.List;

public class Test4_欧拉路 {
	static int[][] graph = {
			{0, 1, 2, 1},
		      {1, 0, 0, 0},
		      {2, 0, 0, 1},
		      {1, 0, 1, 0}
	};
	static int n = 4;
	static int[][] visited = new int[4][4];
	static List<Character> res = new ArrayList<>();
	public static void main(String[] args) {
		dfs(1);
		
		System.out.println(res);
	}

	public static void dfs(int i) {
		res.add((char)('A' + i));
		
		for (int j = 0; j < n; j++) {
			if (graph[i][j] != 0 && visited[i][j] < graph[i][j]) {
				visited[i][j]++;
				visited[j][i]++;
				dfs(j);
			}
		}
	}
}
