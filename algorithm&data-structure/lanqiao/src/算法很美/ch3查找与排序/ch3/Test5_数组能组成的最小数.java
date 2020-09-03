package 算法很美.ch3查找与排序.ch3;

import java.util.Arrays;
import java.util.Comparator;

public class Test5_数组能组成的最小数 {
	public static void main(String[] args) {
		Integer[] A = {3, 2, 1};
		System.out.println(f(A));
	}
	
	public static int f(Integer[] A) {
		Arrays.sort(A, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Integer.parseInt(o1+""+o2);
				int b = Integer.parseInt(o2+""+o1);
				return a-b;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length; i++) {
			sb.append(A[i]);
		}
		return Integer.parseInt(sb.toString());
	}
}
