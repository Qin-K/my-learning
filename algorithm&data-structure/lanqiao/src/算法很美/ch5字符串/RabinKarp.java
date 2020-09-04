package 算法很美.ch5字符串;

public class RabinKarp {
	public static void main(String[] args) {
		f1("AB", "ABABAB");
		// f2("bababb", "babababcbabababb");
	}
	
	public static void f1(String s1, String s2) {
		long code1 = hash(s1);
		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			String s = s2.substring(i, i + s1.length());
			long code = hash(s);
			if (code == code1) {
				System.out.println(i);
			}
		}
	}
	
	public static void f2(String s1, String s2) {
		long code1 = hash(s1);
		long[] code2 = hash(s2, s1.length());
		for (int i = 0; i < code2.length; i++) {
			if (code1 == code2[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static long hash(String s) {
		long code = 0;
		for (int i = 0; i < s.length(); i++) {
			code = (code * 31 + s.charAt(i)) % Long.MAX_VALUE;
		}
		
		return code;
	}
	
	// 滚动hash
	public static long[] hash(String s, int n) {
		long[] res = new long[s.length() - n + 1];
		long code = res[0] = hash(s.substring(0, n));
		
		for (int i = 1; i <= s.length() - n; i++) {
			char newChar = s.charAt(i + n - 1);
			char oldChar = s.charAt(i - 1);
			code = (code * 31 + newChar - (int)Math.pow(31, n) * oldChar) % Long.MAX_VALUE;
			res[i] = code;
		}
		
		return res;
		
	}
}
