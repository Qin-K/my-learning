package 算法很美.ch6数学问题;

import java.util.ArrayList;
import java.util.List;

public class Test01_天枰称重 {
	public static void main(String[] args) {
		f1(5);
	}

	// 天枰称重
	public static void f1(int n) {
		String s = Integer.toString(n, 3);
		char[] chars = new StringBuilder(s).reverse().toString().toCharArray();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '2') {
				list.add(-1);
				if (i == chars.length - 1) {
					list.add(1);
				} else {
					chars[i + 1]++;
				}
			} else {
				list.add(chars[i] - '0');
			}
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i) != 0) {
				System.out.print((int) Math.pow(3, i) * list.get(i));
			}
		}
	}
}
