package 算法很美.ch6数学问题.test;

import java.util.Scanner;

public class Test06_AB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int b = sc.nextInt();
			cal(b, 9973, 1);
			
			System.out.println(x * n % 9973);
		}
	}
	static int x;
	static int y;
	public static int extGcd(int a, int b) {
		if (b == 0) {
			x = 1;
			y = 0;
			return a;
		}
		int res = extGcd(b, a % b);
		int x1 = x, y1 = y;
		x = y1;
		y = x1 - a / b * y1;
		return res;
	}
	
	public static int cal(int a, int b, int m) {
		int d = extGcd(a, b);
		if (m % d != 0) {
			return 0;
		}
		
		x *= m / d;
		int t = b / d;
		x = (x % t + t) % t;
		y *= y / d;
		return d;
	}
}
