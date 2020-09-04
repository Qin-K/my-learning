package 算法很美.ch3查找与排序.ch3;

public class Test1_排序数组中找和因子 {
	public static void main(String[] args) {
		int[] A = {1, 2,3 ,4,5,6};
		f(A, 6);
	}

	public static void f(int[] A, int target) {
		int n = A.length;
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			if (A[left] + A[right] == target) {
				System.out.println("(" + A[left] + "," + A[right] + ")");
				left++;
				right--;
			} else if (A[left] + A[right] < target) {
				left++;
			} else {
				right--;
			}
		}
	}
}
