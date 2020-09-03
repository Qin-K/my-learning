package 算法很美.ch3查找与排序.分治;

import java.util.Arrays;

public class Test4_最小可用id {
	public static void main(String[] args) {
		int[] arr = {1, 3, 4};
		System.out.println(f1(arr));
	}
	
	// 方法1, 排序后扫描
	public static int f1(int[] arr) {
		int n = arr.length;
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if (arr[i] != i + 1) {
				return i+1;
			}
		}
		return n + 1;
	}
	// 方法2, 开辟辅助数组
	public static int f2(int[] arr) {
		int n = arr.length;
		boolean[] help = new boolean[n+1];
		for (int i = 0; i < n; i++) {
			if (arr[i] <= n) {
				help[arr[i]] = true;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (!help[i]) {
				return i;
			}
		}
		return n+1;
	}
	
	// 方法3， partition
	public static int f3(int[] arr, int L, int R) {
		if (L > R) {
			return L + 1;
		}
		int mid = L + ((R - L) >> 1);
		int q = Test2_数组中第K小元素.selectK(arr, L, R, mid - L + 1);
		if (q == mid + 1) {
			return f3(arr, mid + 1, R);
		} else {
			return f3(arr, L, mid - 1);
		}
	}
}
