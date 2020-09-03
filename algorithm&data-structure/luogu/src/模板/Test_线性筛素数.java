package 模板;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Test_线性筛素数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[] primes = new boolean[N + 1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		for (int i = 2; i <= N; i++) {
			if (!primes[i]) continue;
			
			if (!isPrime(i)) primes[i] = false;
			for (int j = 2; i * j <= N; j++) {
				primes[i * j] = false;
			}
		}
		
		for (int i = 0; i < M; i++) {
			if (primes[sc.nextInt()]) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
	
	public static boolean isPrime(int n) {
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}
}
