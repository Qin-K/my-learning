package 算法很美.ch5字符串;

public class Test04_替换字符串中的空格 {
	public static void main(String[] args) {
		String s = f2("hell o000000000".toCharArray(), 6);
		System.out.println(s);
	}

	// 替换字符串中的空格
	public static String f1(String s, int length) {
		return s.replaceAll("//s", "%20");
	}

	public static String f2(char[] chars, int length) {
		int cnt = length;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				cnt += 2;
			}
		}

		int p = cnt - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (chars[i] == ' ') {
				chars[p--] = '0';
				chars[p--] = '2';
				chars[p--] = '%';
			} else {
				chars[p--] = chars[i];
			}
		}

		return new String(chars, 0, cnt);
	}
}
