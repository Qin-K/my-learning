package 算法很美.ch7深入递归.dfs;

import java.util.Scanner;

public class Test6_困难的串 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		dfs("");
		
	}
	static int n;
	static int l;
	static int cnt;
	public static void dfs(String prefix) {
		if (cnt == n) {
			System.out.println(prefix);
			System.exit(0);
		}
		for (char i = 'A'; i < 'A' + l; i++) {
			if (isHard(prefix, i)) {
				cnt++;
				String s = prefix + i;
				dfs(s);
			}
		}
	}
	
	public static boolean isHard(String prefix, char i) {
		int n = prefix.length();
		for (int j = n; j > n / 2; j--) {
			if (j == n) {
				if (prefix.charAt(n - 1) == i) {
					return false;
				};
			} else {
				String s1 = prefix.substring(j) + i;
				String s2 = prefix.substring(j - s1.length(), j);
				if (s1.equals(s2)) return false;
			}
			
		}
		return true;
	}
}
