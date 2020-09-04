package 算法很美.ch5字符串;

public class Test10_回文串 {
	public static void main(String[] args) {
		System.out.println(f2("heeh"));
	}

	// 回文串
	public static boolean f1(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		return new StringBuilder(s).reverse().equals(s);
	}
	
	public static boolean f2(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		char[] charArr = s.toCharArray();
		int i = 0;
		int n = charArr.length;
		while (i <  n / 2) {
			if (charArr[i] != charArr[n-1-i]) {
				return false;
			}
			i++;
		}
		return true;
	}
}
