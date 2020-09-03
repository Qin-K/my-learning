package 算法很美.ch8贪心和动态规划.动态规划;
/*
有n个重量和价值分别为wi，vi的物品，从这些物品中挑选出总重量不超过W的物品，求所有挑选方案中价值总和的最大值。

    1≤n≤100

    1≤wi，vi≤100

    1≤W≤10000

输入：

    n=4
    (w,v)={(2,3),(1,2),(3,4),(2,2)}
    W=5

输出：

    7（选择第0，1，3号物品）

因为对每个物品只有选和不选两种情况，所以这个问题称为01背包。

 */
public class Test1_01背包 {
	public static void main(String[] args) {
		
		int res = dfs(W, 0);
		System.out.println(res);
		for (int i = 0; i < record.length; i++) {
			for (int j = 0; j < record[0].length; j++) {
				record[i][j] = - 1;
			}
		}
		res = dfs2(W, 0);
		System.out.println(res);
		System.out.println(dp());
		/*int max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}*/
		// System.out.println(list);
		// System.out.println(max);
	}
	
	static int[] w = {2, 1, 3, 2};
	static int[] v = {3, 2, 4, 2};
	static int n = 4;
	static int W = 5;
	static int[][] record = new int[W+1][w.length];
	/*	static List<Integer> list = new ArrayList<>();
		static int value;
		private static void dfs(int W, int i) {
			if (i == w.length || W < w[i]) {
				list.add(value);
				return;
			}
			dfs(W, i+1);
			value += v[i];
			dfs(W - w[i], i+1);
			value -= v[i];
		}*/
	
	private static int dfs(int ww, int i) {
		if (i == w.length || ww <= 0) return 0;
		// 不选
		int v1 = dfs(ww, i + 1);
		// 选
		if (ww >= w[i]) {
			int v2 = v[i] + dfs(ww - w[i], i+1);
			return Math.max(v1, v2);
		} else {
			return v1;
		}
	}
	
	// 记忆性递归
	private static int dfs2(int ww, int i) {
		if (i == w.length || ww <= 0) return 0;
		if (record[ww][i] >= 0) {
			return record[ww][i];
		}
		int v1 = dfs2(ww, i+1);
		int ans = v1;
		if (ww >= w[i]) {
			int v2 = v[i] + dfs2(ww - w[i], i+1);
			ans  =  Math.max(v1, v2);
		}
		record[ww][i] = ans; // 对结果进行记录
		return ans;
	}
	
	// 动态规划
	public static int dp() {
		int[][] rec = new int[n][W+1];
		// 初始化第一行
		for (int i = 0; i < W+1; i++) {
			if (i >= w[0]) {
				rec[0][i] = v[0];
			}
		}
		// dp计算后面
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= W; j++) { // 背包容量
				int v1 = rec[i-1][j]; // 不要当前物品
				if (j >= w[i]) {
					int v2 = v[i] + rec[i-1][j - w[i]];
					rec[i][j] = Math.max(v1, v2);
				} else {
					rec[i][j] = v1;
				}
			}
		}
		
		/*for (int i = 0; i < n; i++) {
			for (int j = 0; j < W + 1; j++) {
				System.out.print(rec[i][j] + " ");
			}
			System.out.println();
		}*/
		return rec[n - 1][W];
	}
}
