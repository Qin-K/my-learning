package 算法很美.ch3查找与排序.树堆;

import java.util.Arrays;

public class MaxHeap {
	public static void main(String[] args) {
		int[] A = {2, 5, 4, 3, 7, 5};
		sort(A);
		System.out.println(Arrays.toString(A));
	}
	
	public static void MaxHeap(int[] A) {
		int n = A.length;
		for (int i = (n - 1) / 2; i >= 0; i--) {
			MaxHeapFixDown(A, i, n);
		}
	}
	public static void MaxHeapFixDown(int[] A, int i, int n) {
		int L = 2 *i + 1;
		int R = 2 * i + 2;
		
		// 没有左右孩子不需要调整
		if (L >= n) {
			return;
		}
		int max = L;
		// 只有左孩子，左孩子为最小值
		if (L == n - 1) {
			max = L;
		} else {
			// 比较求最大值
			if (A[L] < A[R]) {
				max = R;
			}
		}
		// 比最大值大，及比左右孩子大，不需要调整
		if (A[i] > A[max]) {
			return;
		}
		// 调整交换
		swap(A, max, i);
		// 递归对孩子进行调整
		MaxHeapFixDown(A, max, n);
	}
	
	public static void sort(int[] A) {
		// 建立大根堆
		MaxHeap(A);
		// 将依次将根元素和尾元素交换
		int n = A.length;
		for (int i = n - 1; i >= 0; i--) {
			swap(A, 0, i);
			// 去掉尾元素根元素向下调整
			MaxHeapFixDown(A, 0, i);
		}
	}
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
