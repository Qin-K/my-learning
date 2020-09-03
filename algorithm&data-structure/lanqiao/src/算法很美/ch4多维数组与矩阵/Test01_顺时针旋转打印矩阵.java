package 算法很美.ch4多维数组与矩阵;

public class Test01_顺时针旋转打印矩阵 {
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3},
				{8, 0, 4},
				{7, 6, 5},
			};
		f1(matrix);
	}

	// 顺时针旋转打印矩阵
	public static void f1(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int tR = 0, tC = 0;
		int bR = rows - 1, bC = cols - 1;

		while (tR <= bR && tC <= bC) {

			// 上
			for (int i = tC; i <= bC; i++) {
				System.out.print(matrix[tR][i] + " ");
			}

			// 右
			for (int i = tR + 1; i <= bR; i++) {
				System.out.print(matrix[i][bC] + " ");
			}

			// 下
			for (int i = bC - 1; i >= tC; i--) {
				System.out.print(matrix[bR][i] + " ");
			}

			// 左
			for (int i = bR - 1; i > tR; i--) {
				System.out.print(matrix[i][tC] + " ");
			}

			tR++;
			tC++;
			bR--;
			bC--;
		}
	}
}
