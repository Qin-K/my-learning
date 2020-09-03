package 算法很美.ch3查找与排序.递归基础;

import java.util.Arrays;

public class Test7_递归插入排序 {
	public static void main(String[] args) {
		int[] arr = { 6, 7, 8, 1, 2, 3 };
		insertSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	public static void insertSort(int[] arr, int n) {
		if (n == 0) {
			return;
		}
		insertSort(arr, n - 1);
		for (int i = n - 1; i > 0 && arr[i] < arr[i - 1]; i--) {
			int temp = arr[i];
			arr[i] = arr[i - 1];
			arr[i - 1] = temp;
		}
	}
}
