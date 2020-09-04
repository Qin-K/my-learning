package 算法很美.ch4多维数组与矩阵;

public class Test03_Z形打印 {
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3},
				{8, 0, 4},
				{7, 6, 5},
			};
		f3(matrix);
	}
	// Z形打印
	public static void f3(int[][] matrix) {
		int dR = 0, dC = 0;
		int rR = 0, rC = 0;
		boolean fromUp = true;

		while (dC != matrix[0].length) {
			if (fromUp) {
				for (int i = dR, j = dC; i >= rR; i--, j++) {
					System.out.print(matrix[i][j] + " ");
				}
			} else {
				for (int i = rR, j = rC; i <= dR; i++, j--) {
					System.out.print(matrix[i][j] + " ");
				}
			}

			fromUp = !fromUp;
			if (dR != matrix.length - 1) {
				dR++;
			} else {
				dC++;
			}

			if (rC != matrix[0].length - 1) {
				rC++;
			} else {
				rR++;
			}
		}
	}
}
