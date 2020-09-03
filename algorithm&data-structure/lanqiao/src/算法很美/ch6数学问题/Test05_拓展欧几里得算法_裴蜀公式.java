package 算法很美.ch6数学问题;

public class Test05_拓展欧几里得算法_裴蜀公式 {
	public static void main(String[] args) {
		cal(4, 2, 6);
		System.out.println(x + " " + y);
	}
	
	static int x;
	static int y;
	// 拓展欧几里得算法
	public static int extGcd(int a, int b) {
		if (b == 0) {
			x = 1;
			y = 0;
			return a; // gcd
		}
		
		int res = extGcd(b, a % b);
		int x1 = x, y1 = y;
		x = y1;
		y = x1 - a / b * y1;
		return res;
	}
	
	// 求解线性方程
	public static int cal(int a, int b, int m) {
		int d = extGcd(a, b);
		if (m % d != 0) {
			return 0;
		}
		x *= m / d;
		y *= m / d;
		return d;
	}
	
	// 求解逆元
	public static int inverseElement(int a, int b) {
		int d = cal(a, b, 1);
		x = (x % b + b) % b;
		return d;
	}
}
