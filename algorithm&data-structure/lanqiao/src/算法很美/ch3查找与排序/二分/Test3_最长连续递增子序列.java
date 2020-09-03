package 算法很美.ch3查找与排序.二分;

public class Test3_最长连续递增子序列 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 2};
		System.out.println(f(arr));
	}
	
	public static int f(int[] arr) {
		int p = 0;
		int max = 1;
		int s = 1;
		while (p < arr.length - 1) {
			if (arr[p + 1] > arr[p]) {
				s++;
			} else {
				if (s > max) {
					max = s;
				}
				s = 1;
			}
			p++;
		}
		return max;
		
	}
}
