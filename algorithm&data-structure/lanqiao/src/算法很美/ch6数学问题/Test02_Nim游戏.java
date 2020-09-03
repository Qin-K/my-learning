package 算法很美.ch6数学问题;

import java.util.Scanner;

public class Test02_Nim游戏 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			res ^= A[i];
		}
		System.out.println(res != 0);
	}
}
