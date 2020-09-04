package 算法很美.ch3查找与排序.递归基础;

public class Test3_数组求和 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(f(arr, 0, arr.length - 1));
	}
	
	public static int f(int[] arr, int l, int r) {
		if (l == r) {
			return arr[l];
		}
		return arr[l] + f(arr, l + 1, r);
		
	}
}
