package 算法很美.ch4多维数组与矩阵;

public class Test05_矩阵相乘 {
	public static void main(String[] args) {
		int[][] A = {
				{1, 2, 3},
				{1, 2, 3},
				{1, 2, 3}
		};
		
		int[][] B = {
				{1, 2, 3},
				{1, 2, 3},
				{1, 2, 3}
		};
		int[][] result = f7(A, B);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] f7(int[][] A, int[][] B) {
		int m = A.length;
		int n = B[0].length;
		int[][] result = new int[m][n];
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				for (int k = 0; k < B.length; k++) {
					result[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return result;
	}
}
