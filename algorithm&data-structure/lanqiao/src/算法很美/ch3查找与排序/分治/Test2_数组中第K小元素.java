package 算法很美.ch3查找与排序.分治;

public class Test2_数组中第K小元素 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(selectK(arr, 0, arr.length - 1, 2));
	}

	public static int selectK(int[] arr, int L, int R, int k) {
		int q = partition(arr, L, R);
		int qK = q - L + 1;
		if (qK == k) {
			return arr[q];
		} else if (qK > k) {
			return selectK(arr, L, q - 1, k);
		} else {
			return selectK(arr, q + 1, R, k - qK);
		}
	}

	public static int partition(int[] arr, int L, int R) {
		int pivot = arr[L];
		int sp = L + 1;
		int bigger = R;
		while (sp <= bigger) {
			if (arr[sp] <= pivot) {
				sp++;
			} else {
				swap(arr, sp, bigger--);
			}
		}
		swap(arr, L, bigger);
		return bigger;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
