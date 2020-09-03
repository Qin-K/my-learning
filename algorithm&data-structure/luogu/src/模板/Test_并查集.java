package 模板;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test_并查集 {
	static int[] father = new int[10005];
	public static int find(int x) {
		Set<Integer> path = new HashSet<>();
		while (father[x] != 0) {
			path.add(x);
			x = father[x];
		}
		
		for (int n : path) {
			father[n] = x;
		}
		
		return x;
	}
	public static void union(int x, int y) {
		father[find(y)] = find(x);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int z = sc.nextInt();
			int x = sc.nextInt(), y = sc.nextInt();
			x = find(x);
			y = find(y);
			switch (z) {
			case 1:
				if (x != y) union(x, y);
				break;
			case 2:
				if (x == y) {
					System.out.println("Y");
				} else {
					System.out.println("N");
				}
				break;

			default:
				break;
			}
		}
	}
}
