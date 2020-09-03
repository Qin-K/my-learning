package 算法很美.ch3查找与排序.二分;

public class Test2_含空字符串有序数组查找 {
	public static void main(String[] args) {
		String[] arr = {"aello","borld","","","good"};
		System.out.println(f(arr, "hello"));
	}
	
	public static int f(String[] arr, String target) {
		int L = 0;
		int R = arr.length - 1;
		int mid = (L + R) / 2;
		if (arr.length == 0) {
			return arr[0].equals(target) ? 0 : -1;
		}
		while (L <= R) {
			while (arr[mid].equals("")) {
				if (mid == R) {
					break;
				}
				mid++;
			}
			if (mid == R) {
				mid = (L + R) / 2;
				while (arr[mid].equals("")) {
					if (mid == L) {
						return -1;
					}
					mid--;
				}
			}
			if (arr[mid].compareTo(target) < 0) {
				L = mid + 1;
			} else if (arr[mid].compareTo(target) > 0) {
				R = mid - 1;
			} else {
				return mid;
			}
		}
		
		return -1;
		
	}
}
