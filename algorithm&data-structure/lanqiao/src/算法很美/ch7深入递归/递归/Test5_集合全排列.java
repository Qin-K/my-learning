package 算法很美.ch7深入递归.递归;

import java.util.ArrayList;
import java.util.List;

public class Test5_集合全排列 {
	public static void main(String[] args) {
		System.out.println(f1("ABC"));
	}

	// 集合全排列
	public static List<String> f1(String set) {
		List<String> res = new ArrayList<String>();
		char[] charArr = set.toCharArray();
		res.add(charArr[0] + "");
		for (int i = 1; i < charArr.length; i++) {
			char c = charArr[i];
			List<String> help = new ArrayList<>();
			for (String s : res) {
				help.add(c + s);
				help.add(s + c);

				for (int j = 1; j < s.length(); j++) {
					String temp = s.substring(0, j) + c + s.substring(j, s.length());
					help.add(temp);
				}
				res = help;
			}
		}

		return res;
	}

	// 交换法
	static List<String> res = new ArrayList<>();

	public static void f2(char[] set, int k) {
		if (k == set.length - 1) {
			res.add(new String(set));
		}
		for (int i = k; i < set.length; i++) {
			swap(set, i, k);
			f2(set, k + 1);
			swap(set, k, i);
		}
	}

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
