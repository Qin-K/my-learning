package 算法很美.ch6数学问题;

public class Test11_快速幂运算 {
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		System.out.println(pow(3, 25));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1 + "ms");
		System.out.println(Math.pow(3, 25));
		long t3 = System.currentTimeMillis();
		System.out.println(t3 - t2 + "ms");
	}
	
	public static long pow(int x, int n) {
		if (n == 1) return x;
		if (n == 0) return 1;
		int t = 1;
		int p = x;
		while ((t << 1) < n) {
			p *= p;
			t <<= 1;
		}
		
		long p2 = pow(x, n - t);
		return p * p2;
	}
}
