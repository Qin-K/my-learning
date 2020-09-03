package 算法很美.ch6数学问题;

public class Test10_素数筛法 {
	public static void main(String[] args) {
		int res = f(3);
		System.out.println(res);
	}
	
	
	public static boolean isPrime(int n) {
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	public static int f(int N) {
		int n = 2;
		while (n / Math.log(n) < N) {
			n++;
		}
		boolean[] primes = new boolean[n];
		
		for (int i = 2; i < n; i++) {
			if (primes[i]) {
				continue;
			}
			
			if (!isPrime(i)) {
				primes[i] = true;
			}
			
			for (int k = 2; i * k < n; k++) {
				primes[i * k] = true;
			}
		}
		
		int cnt = 0;
		for (int i = 2; i < n; i++) {
			if (!primes[i]) cnt++;
			if (cnt == N) {
				return i;
			}
		}
		
		return -1;
	}
}
