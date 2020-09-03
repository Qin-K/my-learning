package 算法很美.ch6数学问题;

public class Test03_欧几里得算法 {
	public static void main(String[] args) {
		System.out.println(gcd(6, 8));
	}

	// 求最大公约数
	public static int gcd(int m, int n) {
		return n == 0 ? m : gcd(n, m % n);
	}
}
