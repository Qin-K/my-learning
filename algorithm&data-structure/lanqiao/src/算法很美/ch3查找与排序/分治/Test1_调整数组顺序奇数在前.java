package 算法很美.ch3查找与排序.分治;

import java.util.Arrays;

public class Test1_调整数组顺序奇数在前 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		f1(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void f1(int[] arr) {
		int sp = 0;
		int left = arr.length - 1;
		while (sp <= left) {
			if (arr[sp] % 2 != 0) {
				sp++;
			} else {
				swap(arr, sp, left--);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
