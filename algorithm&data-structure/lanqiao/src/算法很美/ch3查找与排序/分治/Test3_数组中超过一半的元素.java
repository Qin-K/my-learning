package 算法很美.ch3查找与排序.分治;

import java.util.Arrays;

public class Test3_数组中超过一半的元素 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 1, 3};
		System.out.println(f(arr));
		
	}
	
	// 方法1, 排序后返回
	public static int f1(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length/2];
	}
	// 方法2, 分区方式查找中间元素
	public static int f2(int[] arr) {
		int res = Test2_数组中第K小元素.selectK(arr, 0, arr.length - 1, arr.length/2);
		return res;
	}
	
	// 方法3
	public static int f3(int[] arr) {
		int result = arr[0];
		int cnt = 1;
		for (int i = 1; i < arr.length; i++) {
			if (cnt == 0) {
				result = arr[i];
				cnt = 1;
				continue;
			}
			
			if (arr[i] == result) {
				cnt++;
			} else {
				cnt--;
			}
		}
		
		return result;
	}
	
	/**
	 * 发帖水王恰好一半 
	 */
	public static int f(int[] arr) {
		int result = arr[0];
		int cnt = 0;
		int lastCnt = 0;
		for (int i = 0; i < arr.length ; i++) {
			if (arr[i] == arr[arr.length - 1]) {
				lastCnt++;
			}
			if (cnt == 0) {
				result = arr[i];
				cnt = 1;
				continue;
			}
			
			if (arr[i] == result) {
				cnt++;
			} else {
				cnt--;
			}
		}
		
		if (lastCnt == arr.length / 2) {
			return arr[arr.length - 1];
		} else {
			return result;
		}
	}
}
