package 算法很美.ch5字符串;

public class Test01_字符串中有无重复字符 {
	public static void main(String[] args) {
		System.out.println(f("hello"));
	}

	// 判断字符串中有无重复字符
	public static boolean f(String s) {
		boolean[] help = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			int c = (char) s.charAt(i);
			if (help[c])
				return false;
			else
				help[c] = true;
		}

		return true;
	}
}
