package 数据结构不难.ch12图论.dfs;

public class Test3_拓扑排序 {
	static char[] v = {'a', 'b', 'c', 'd'};
	static int[][] graph = {
			{0, 1, 0, 0},
		    {0, 0, 0, 0},
		    {0, 1, 0, 0},
		    {0, 0, 1, 0},
	};
	static char[] res = new char[4];
	static int t = 4;
	static boolean[] visited = new boolean[4];
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}
		
		for (int i = 0; i < 4; i++) {
			System.out.print(res[i] + " ");
		}
	}
	
	public static void dfs(int i) {
		for (int j = 0; j < 4; j++) {
			if (graph[i][j] != 0) {
				if (!visited[j])
					dfs(j);
			}
		}
		
		visited[i] = true;
		res[t-- - 1] = v[i];
	}
}
