package 算法很美.ch3查找与排序.二分;

/**
 * 1. 判断左右边界大小，如果左边界小于有边界表示没有旋转
 * 2. 依次取中间值，进行二分，中间值大于左边说明最小值在右边L = mid
 * 									否则最小值在左边R = mid
 * 3. 最终R所在位置就是最小值
 * @author Qin-Kai
 *
 */
public class Test1_有序数组的旋转最小值 {
	public static void main(String[] args) {
		int[] arr = {3, 4, 5, 1, 2};
		System.out.println(f(arr));
	}
	
	public static int f(int arr[]) {
		int L = 0;
		int R = arr.length - 1;
		int mid = (L + R) / 2;
		if (arr[L] < arr[R]) {
			return arr[L];
		}
		while (L + 1 < R) {
			if (arr[mid] > arr[L]) {
				L = mid;
				mid = (L + R) / 2;
			} else {
				R = mid;
				mid = (L + R) / 2;
			}
		}
		return arr[R];
	}
}
