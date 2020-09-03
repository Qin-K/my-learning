package 算法很美.ch4多维数组与矩阵;

public class Test02_0所在行列清0 {
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3},
				{8, 0, 4},
				{7, 6, 5},
			};
		f2(matrix);
	}

	// 0所在的行列清零
	public static void f2(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		boolean[] M = new boolean[rows];
		boolean[] N = new boolean[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					M[i] = true;
					N[j] = true;
				}
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (M[i] || N[j]) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
