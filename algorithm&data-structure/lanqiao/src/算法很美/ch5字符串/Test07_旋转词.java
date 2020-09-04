package 算法很美.ch5字符串;

public class Test07_旋转词 {
	public static void main(String[] args) {
		boolean res = f("hello", "llohe");
		System.out.println(res);
	}

	// 旋转词
	public static boolean f(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		String s = s1 + s1;
		return s.contains(s2);
	}
}
