package 算法很美.ch7深入递归.递归;

public class Test2_机器人走方格 {
	public static void main(String[] args) {
		System.out.println(f21(3, 3));
	}

	// 机器人走方格
	public static int f21(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}

		return f21(m - 1, n) + f21(m, n - 1);
	}

	public static int f22(int m, int n) {
		int[][] state = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					state[i][j] = 1;
				else
					state[i][j] = state[i - 1][j] + state[i][j - 1];
			}
		}

		return state[m - 1][n - 1];
	}
}
