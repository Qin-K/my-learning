package 算法很美.ch5字符串;

public class Test02_翻转字符串 {
	public static void main(String[] args) {
		System.out.println(f("hello"));
	}

	// 翻转字符串
	public static String f(String s) {
		char[] chars = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			chars[i] = s.charAt(s.length() - 1 - i);
		}
		return new String(chars);
	}
}
