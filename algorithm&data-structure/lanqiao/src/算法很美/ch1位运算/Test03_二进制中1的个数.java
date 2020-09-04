package 算法很美.ch1位运算;
import java.util.Scanner;

/**
 * 1. 判断第i为是否为1 (n & (1 << i) == (1 << i))
 * 2. 将n转化为2进制然后遍历Integory.toString(n, 2)
 * 3. ((n - 1) & n)会消除最低位的1，直到n等于0统计1的个数
 * @author Qin-Kai
 *
 */
public class Test03_二进制中1的个数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt= 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) == (1 << i)) cnt++;
		}
		
		System.out.println(cnt);
		cnt = 0;
		String s = Integer.toString(n, 2);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') cnt++;
		}
		System.out.println(cnt);
		
		cnt=0;
		while (n != 0) {
			n = ((n-1) & n);
			cnt++;
		}
		System.out.println(cnt);
		
	}
}
