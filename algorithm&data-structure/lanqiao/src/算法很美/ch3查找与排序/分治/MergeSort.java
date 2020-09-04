package 算法很美.ch3查找与排序.分治;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 3, 2, 5, 6, 4};
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr, int L, int R) {
		int mid = L + ((R - L) >> 1);
		if (L < R) {
			mergeSort(arr, L, mid);
			mergeSort(arr, mid + 1, R);
			merge(arr, L, mid, R);
		}
	}
	static int[] help = new int[500];
	public static void merge(int[] arr, int L, int mid, int R) {
		System.arraycopy(arr, L, help, L, R - L + 1);
		int p1 = L;
		int p2 = mid + 1;
		int cur = L;
		while (p1 <= mid && p2 <= R) {
			if (help[p1] < help[p2]) {
				arr[cur++] = help[p1++];
			} else {
				arr[cur++] = help[p2++];
			}
		}
		
		while (p1 <= mid) {
			arr[cur++] = help[p1++];
		}
		while (p2 <= R) {
			arr[cur++] = help[p2++];
		}
		
	}
}
