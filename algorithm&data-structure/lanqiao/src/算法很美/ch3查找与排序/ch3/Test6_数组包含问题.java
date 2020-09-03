package 算法很美.ch3查找与排序.ch3;

import java.util.Arrays;

public class Test6_数组包含问题 {
	public static void main(String[] args) {
		System.out.println(f("abc", "abcd"));
	}
	public static boolean f(String s1, String s2) {
		/*for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (s2.indexOf(c) == -1) {
				return false;
			}
		}
		return true;*/
		
		char[] chars = s2.toCharArray();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (Arrays.binarySearch(chars, c) < 0) {
				return false;
			}
		}
		
		return true;
	}
}
