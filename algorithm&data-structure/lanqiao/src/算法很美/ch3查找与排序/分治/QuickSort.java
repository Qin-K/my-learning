package 算法很美.ch3查找与排序.分治;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		// partition(arr, 0, arr.length-1);
		// int p = partition2(arr, 0, arr.length - 1);
		// System.out.println(p);
		int[] p = partition3(arr, 0, arr.length - 1);
		System.out.println(p[0] + "--" + p[1]);
		// quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * 快速排序
	 */
	public static void quickSort(int[] arr, int L, int R) {
		if (L < R) {
			// int p = partition(arr, L, R);
			/*int p = partition2(arr, L, R);
			quickSort(arr, L, p - 1);
			quickSort(arr, p + 1, R);*/
			int[] p = partition3(arr, L, R);
			quickSort(arr, L, p[0]);
			quickSort(arr, p[1], R);
		}
	}
	
	/**
	 * 单向扫描分区
	 */
	public static int partition(int[] arr, int L, int R) {
		int pivot = arr[L];
		int sp = L + 1;
		int bigger = R;
		while (sp <= bigger) {
			if (arr[sp] <= pivot) {
				sp++;
			} else {
				swap(arr, sp, bigger);
				bigger--;
			}
		}
		// 交换结束后bigger指向的是最后一个比pivot小得位置
		// 将主元和bigger交换
		swap(arr, L, bigger);
		return bigger;
	}
	
	/**
	 * 双向扫描分区 
	 */
	public static int partition2(int[] arr, int L, int R) {
		int pivot = arr[L];
		int left = L + 1;
		int right = R;
		while (left <= right) {
			while (left <= R && arr[left] <= pivot) {
				left++;
			}
			while (right >= L && arr[right] > pivot) {
				right--;
			}
			if (left < right) {
				swap(arr, left, right);
			}
		}
		swap(arr, right, L);
		return right;
	}
	
	/**
	 * 划分三个区间
	 */
	public static int[] partition3(int[] arr, int L, int R) {
		int pivot = arr[L];
		int less = L;
		int more = R + 1;
		int sp = L + 1;
		while (sp < more) {
			if (arr[sp] < pivot) {
				swap(arr, sp++, ++less);
			} else if (arr[sp] > pivot) {
				swap(arr, sp, --more);
			} else {
				sp++;
			}
		}
		swap(arr, L, less);
		return new int[] {less, more-1};
	}
	
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
