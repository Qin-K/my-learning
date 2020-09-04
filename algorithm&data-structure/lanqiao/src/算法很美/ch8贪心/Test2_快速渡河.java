package 算法很美.ch8贪心和动态规划.贪心;

import java.util.Arrays;
import java.util.Scanner;

public class Test2_快速渡河 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);
		int res = f(a, n);
		System.out.println(res);
	}

	private static int f(int[] a, int n) {
		int ans = 0;
		while (n > 0) {
			if (n == 1) {
				ans += a[0];
				break;
			} else if (n == 2) {
				ans += a[1];
				break;
			} else if (n == 3) {
				ans += a[0] + a[1] + a[2];
				break;
			} else {
				// 1将最慢的运过回来
				int s1 = 2 * a[0]  + a[n - 1] + a[n - 2];
				int s2 = a[0] + 2 * a[1] + a[n - 1];
				ans += Math.min(s1, s2); 
				n -= 2;
			}
		}
		
		return ans;
		
	}

}
