package 模板;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Test_快速排序 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		quickSort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.print(i + " ");
		}
		
	}
	
	public static void quickSort(int[] a, int L, int R) {
		if(L >= R) return;
		
		int[] p = patition(a, L, R);
		quickSort(a, L, p[0] - 1);
		quickSort(a, p[1] + 1, R);
	}
	
	public static int[] patition(int[] a, int L, int R) {
		int r = L + (int)(Math.random() * (R - L + 1));
		swap(a, r, L);
		int p = a[L];
		int less = L + 1;
		int more = R;
		int pos = L + 1;
		while (pos <= more) {
			if (a[pos] < p) {
				swap(a, pos++, less++);
			} else if (a[pos] > p) {
				swap(a, pos, more--);
			} else {
				pos++;
			}
		}
		
		swap(a, L, less - 1);
		return new int[] {less - 1, more};
	}
	
	public static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
