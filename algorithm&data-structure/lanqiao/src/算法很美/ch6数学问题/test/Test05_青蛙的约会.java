package 算法很美.ch6数学问题.test;

import java.util.Scanner;

public class Test05_青蛙的约会 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int L = sc.nextInt();
		int a = m - n;
		int b = L;
		m = y - x;
		
		long d = cal(a, b, m);
		if (d != 0) { // 有解
			long t = Math.abs(b / d);
			X = (X % t + t) % t;
			System.out.println(X);
		}
	}
	static long X;
	static long Y;
	public static long extGcd(long a, long b) {
		if (b == 0) {
			X = 1;
			Y = 0;
			return a;
		}
		
		long res = extGcd(b, a % b);
		long x1 = X, y1 = Y;
		X = y1;
		Y = x1 - a / b * y1;
		
		return res;
	}
	
	public static long cal(long a, long b, long m) {
		long d = extGcd(a, b);
		if (m % d != 0) {
			System.out.println("Impossible");
			return 0;
		}
		X *= m / d;
		Y *= m / d;
		
		return d;
	}
}
