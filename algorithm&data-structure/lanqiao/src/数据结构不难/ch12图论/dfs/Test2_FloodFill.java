package 数据结构不难.ch12图论.dfs;

public class Test2_FloodFill {
	static char[][] graph = {
		  "*@@*@".toCharArray(),
	      "**@*@".toCharArray(),
	      "****@".toCharArray(),
	      "@@@*@".toCharArray(),
	      "@@**@".toCharArray(),
	};

	
	public static void main(String[] args) {
		int cnt = 0;
		int N = graph.length;
		int M = graph[0].length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == '@') {
					cnt++;
					dfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
	}
	private static void dfs(int x, int y) {
		graph[x][y] = '*';
		int N = graph.length;
		int M = graph[0].length;
		
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if ( !(i == 0 && j == 0) &&
					 x + i >= 0 && x + i < N &&
					 y + j >= 0 && y + j < M &&
					 graph[x + i][y + j] == '@') {
					dfs(x + i, y + j);
				}
			}
		}
	}

}
