package 算法很美.ch3查找与排序.递归基础;

public class Test9_递归二分查找 {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
		int res = binarySearch(arr, 0, arr.length - 1, 3);
		System.out.println(res);
	}

	public static int binarySearch(int[] arr, int l, int r, int num) {
		if (l > r) {
			return -1;
		}
		int mid = (l + r) / 2;
		if (arr[mid] == num) {
			return mid;
		} else if (arr[mid] < num) {
			return binarySearch(arr, mid + 1, r, num);
		} else {
			return binarySearch(arr, l, mid - 1, num);
		}
	}
}
