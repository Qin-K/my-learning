package 算法很美.ch5字符串;

import java.util.Arrays;

public class Test03_变形词问题 {
	public static void main(String[] args) {
		boolean res = f2("hello", "heoll");
		System.out.println(res);
	}

	// 变形词问题
	public static boolean f1(String s1, String s2) {
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		return Arrays.equals(chars1, chars2);
	}

	public static boolean f2(String s1, String s2) {
		int[] help = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			help[s1.charAt(i)]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			help[s2.charAt(i)]--;
		}

		for (int i = 0; i < help.length; i++) {
			if (help[i] != 0)
				return false;
		}

		return true;
	}
}
