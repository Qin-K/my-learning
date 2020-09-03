package 算法很美.ch5字符串;

public class Test05_压缩字符串 {
	public static void main(String[] args) {
		String s = f5("aaabbbccc");
		System.out.println(s);
	}

	// 压缩字符串
	public static String f5(String s) {
		int cnt = 0;
		char last = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (sb.length() == 0) {
				sb.append(c);
				cnt++;
			} else {
				if (last == c) {
					cnt++;
				} else {
					sb.append(cnt + "" + c);
					cnt = 1;
				}
			}
			last = c;
		}

		if (cnt > 0) {
			sb.append(cnt);
		}
		if (sb.length() >= s.length()) {
			return s;
		}

		return sb.toString();

	}

}
