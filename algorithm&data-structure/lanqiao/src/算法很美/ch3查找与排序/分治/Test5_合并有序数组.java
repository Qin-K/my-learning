package 算法很美.ch3查找与排序.分治;

import java.util.Arrays;

public class Test5_合并有序数组 {
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 0, 0, 0, 0};
		int[] B = {4, 5, 6};
		f(A, 4, B);
		System.out.println(Arrays.toString(A));
	}
	
	/**
	 * 合并有序数组, A有足够的额外空间
	 */
	public static void f(int[] A, int m, int[] B) {
		int n = B.length;
		int p1 = m - 1;
		int p2 = n - 1;
		int cur = m + n -1;
		
		while (p1 >= 0 && p2 >= 0) {
			if (A[p1] > B[p2]) {
				A[cur--] = A[p1--];
			} else {
				A[cur--] = B[p2--];
			}
		}
		
		while (p2 >= 0) {
			A[cur--] = B[p2--];
		}
	}
}
