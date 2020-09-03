package 算法很美.ch3查找与排序.树堆;

import java.util.Arrays;

public class MinHeap {
	public static void main(String[] args) {
		int[] A = {2, 4, 3, 5, 6, 2, 9};
		// MinHeap(A);
		sort(A);
		System.out.println(Arrays.toString(A));
	}
	/**
	 * 创建小根堆
	 */
	public static void MinHeap(int[] A) {
		int n = A.length;
		for (int i = (n - 1) / 2; i >= 0; i--) {
			MinHeapFixDown(A, i, n);
		}
	}
	
	public static void MinHeapFixDown(int[] A, int i, int n) {
		int L = 2*i+1;
		int R = 2*i+2;
		// 没有左右孩子不调整
		if (L >= n) {
			return;
		}
		
		int min = L;
		// 只有右孩子
		if (L == n - 1) {
			min = L;
		} else {
			if (A[L] > A[R]) {
				min = R;
			}
		}
		// 小于等于左右孩子，不需要调整
		if (A[i] <= A[min]) {
			return ;
		}
		swap(A, i, min);
		MinHeapFixDown(A, min, n);
	}
	
	// 堆排序
	public static void sort(int[] A) {
		// 构建堆
		MinHeap(A);
		int n = A.length;
		for (int i = n - 1; i >= 0; i--) {
			// 依次将根元素和最后元素交换
			swap(A, 0, i);
			// 根元素向下调整
			MinHeapFixDown(A, 0, i);
		}
	}
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
