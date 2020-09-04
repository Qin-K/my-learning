package 算法很美.ch4多维数组与矩阵;

import java.util.Arrays;

public class Test04_数组最大累加和 {
	public static void main(String[] args) {
		int[][] matrix = {
				{-1, -1, -1},
				{-1, 3, 2},
				{10, -1, -1}
		};
		System.out.println(f(matrix));
	}
	// 最大累加和暴力解法
	public static int f1(int[] A) {
		int n = A.length;
		int maxSum = A[0];
		for (int i = 0; i < n; i++) {
			int s = A[i];
			for (int j = i + 1; j < n; j++) {
				s += A[j];
				if (s > maxSum) {
					maxSum = s;
				}
			}
		}
		return maxSum;
	}

	// 递推法
	public static int f2(int[] A) {
		int n = A.length;
		int maxSum = A[0];

		int s = A[0];
		int L = 0;
		int R = 0;
		for (int i = 1; i < n; i++) {
			if (s < 0) {
				s = A[i];
				L = i;
			} else {
				s += A[i];
			}
			if (s > maxSum) {
				maxSum = s;
				R = i;
			}
		}

		// System.out.println(L + "->" + R);
		return maxSum;
	}

	// 子矩阵最大累加和
	public static int f(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int max = matrix[0][0];

		int[] help = new int[cols]; // 辅助数组
		for (int i = 0; i < rows; i++) { // 起始累加行
			for (int j = i; j < rows; j++) {
				for (int k = 0; k < cols; k++) {
					help[k] += matrix[j][k];
				}

				int t = f2(help);
				if (t > max) {
					max = t;
				}
			}
			Arrays.fill(help, 0);
		}
		return max;
	}
}
