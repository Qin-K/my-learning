package 算法很美.ch5字符串;

import java.util.HashMap;
import java.util.Map;

public class Test06_串的字符集相同 {
	public static void main(String[] args) {
		boolean res = f6("hell", "hel");
		System.out.println(res);
	}

	// 串的字符集相同
	public static boolean f6(String s1, String s2) {
		Map<Character, Boolean> map = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			map.put(s1.charAt(i), true);
		}

		for (int i = 0; i < s2.length(); i++) {
			if (map.get(s2.charAt(i)) == null) {
				return false;
			} else {
				map.put(s2.charAt(i), false);
			}
		}

		for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
			if (entry.getValue()) {
				return false;
			}
		}

		return true;
	}
}
