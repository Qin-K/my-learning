package 算法很美.ch1位运算;

import java.util.HashSet;
import java.util.Set;

public class Test03_数组中出现k次与出现1次 {
	public static void main(String[] args) {
		int k = 3;
		int[] a = {1, 1, 1, 2, 2, 2, 9, 3, 3, 3};
		
		int res = f(a, k);
		System.out.println(res);
		res = f2(a, k);
		System.out.println(res);
	}
	
	private static int f2(int[] a, int k) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> record = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (set.contains(a[i])) {
				if (record.contains(a[i]))
					record.remove(a[i]);
				continue;
			}
			record.add(a[i]);
		}
		
		int res = 0;
		for (int i : record) {
			res = i;
		}
		
		return res;
		
	}

	private static int f(int[] a, int k) {
		int n = a.length;
		char[][] help = new char[n][];
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			help[i] = new StringBuilder(Integer.toString(a[i], k)).reverse().toString().toCharArray();
			if (help[i].length > maxLen) maxLen = help[i].length;
			
		}
		
		// 做不进位加法
		int[] res = new int[maxLen];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < maxLen; j++) {
				if (j >= help[i].length) {
					res[j] += 0;
				} else {
					res[j] += help[i][j] - '0';
				}
				
				res[j] %= 3;
			}
		}
		StringBuilder  sb = new StringBuilder();
		for (int i = maxLen - 1; i >= 0; i--) {
			sb.append(res[i]);
		}
		
		return Integer.parseInt(sb.toString(), 3);
	}
}
