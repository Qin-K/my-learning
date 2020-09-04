package 算法很美.ch3查找与排序.ch3;

import java.util.Arrays;

public class Test2_需要排序的子数组 {
	public static void main(String[] args) {
		int[] A = {1, 3, 2, 4, 5};
		System.out.println(Arrays.toString(f(A)));
	}
	
	public static int[] f(int[] A) {
		int n = A.length;
		int p1 = 0;
		int p2 = 0;
		int max = A[0];
		int min = A[n-1];
		for (int l = 0, r = n - 1; l < n; l++,r--) {
			if (A[l] > max) {
				max = A[l];
			} 
			
			if (A[r] < min) {
				min = A[r];
			} 
			
			if (A[l] < max) {
				p2 = l;
			}
			
			if (A[r] > min) {
				p1 = r;
			}
		}
		return new int[] {p1, p2};
	}
}
