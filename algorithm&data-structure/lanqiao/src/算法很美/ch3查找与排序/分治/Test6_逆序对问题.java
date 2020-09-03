package 算法很美.ch3查找与排序.分治;

public class Test6_逆序对问题 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 5, 4};
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(result);
 	}
	
	public static void mergeSort(int[] arr, int L, int R) {
		if (L == R) {
			return;
		}
		
		int mid = L + ((R - L) >> 1);
		mergeSort(arr, L, mid);
		mergeSort(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}
	
	static int[] help = new int[500];
	static int result = 0;
	public static int merge(int[] arr, int L, int mid, int R) {
		System.arraycopy(arr, L, help, L, R - L + 1);
		int p1 = L;
		int p2 = mid + 1;
		int cur = L;
		while (p1 <= mid && p2 <= R) {
			if (help[p1] < help[p2]) {
				arr[cur++] = help[p1++];
			} else {
				arr[cur++] = help[p2++];
				result += mid - p1 + 1;
			}
		}
		
		while(p1 <= mid) {
			arr[cur++] = help[p1++];
		}
		
		while(p2 <= R) {
			arr[cur++] = help[p2++];
		}
		
		return result;
	}
}
