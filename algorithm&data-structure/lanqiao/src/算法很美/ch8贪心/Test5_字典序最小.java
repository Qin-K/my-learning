package 算法很美.ch8贪心和动态规划.贪心;

import java.util.Scanner;

/*
字典序最小问题

给一个定长为N的字符串S,构造一个字符串T,长度也为N。

起初，T是一个空串，随后反复进行下列任意操作

1. 从S的头部删除一个字符，加到T的尾部
2. 从S的尾部删除一个字符，加到T的尾部

目标是最后生成的字符串T的字典序尽可能小

1≤N≤2000
字符串S只包含大写英文字母

输入：字符串S
输出：字符串T

POJ - 3617 要求每80个字符换行输出
 */
public class Test5_字典序最小 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(sc.next());
		}
		
		String res = f(sb.toString());
		System.out.println(res);
	}

	private static String f(String s) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		String s1 = new StringBuilder(s).reverse().toString();
		while (sb.length() < n) {
			if (s.compareTo(s1) <= 0) {
				sb.append(s.charAt(0));
				s = s.substring(1, s.length());
			} else {
				sb.append(s1.charAt(0));
				s1 = s1.substring(1, s1.length());
			}
		}
		
		return sb.toString();
	}
}
