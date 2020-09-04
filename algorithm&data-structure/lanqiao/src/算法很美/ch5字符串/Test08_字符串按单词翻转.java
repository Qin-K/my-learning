package 算法很美.ch5字符串;

public class Test08_字符串按单词翻转 {
	public static void main(String[] args) {
		System.out.println(f("hello world"));
	}

	// 字符串按单词翻转
	public static String f(String s) {
		String[] words = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i] + " ");
		}

		sb.deleteCharAt(s.length());

		return sb.toString();
	}
}
