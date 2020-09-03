package 算法很美.ch5字符串;

public class Test09_去除连续出现k次0 {
	public static void main(String[] args) {
		System.out.println(f1("hello000", 3));
	}
	// 去除字符串中连续出现k次0
	public static String f1(String s, int k) {
		String regex = "0{" + k + "}";
		return s.replaceAll(regex, "");
	}

	public static String f2(String s, int k) {
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '0') {
				cnt++;
			} else {
				for (int j = 0; j < cnt % k; j++) {
					sb.append('0');
				}
				sb.append(c);
			}
		}
		for (int i = 0; i < cnt % k; i++) {
			sb.append('0');
		}
		return sb.toString();
	}
}
