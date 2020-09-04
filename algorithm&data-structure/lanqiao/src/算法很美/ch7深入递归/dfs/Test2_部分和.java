package 算法很美.ch7深入递归.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2_部分和 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		k = sc.nextInt();
		dfs(arr, k, 0);
	}

	// 子集变形
	public static void f1(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		for (int i = 0; i < arr.length; i++) {
			List<List<Integer>> help = new ArrayList<>(res);
			for (List<Integer> r : help) {
				List<Integer> temp = new ArrayList<>(r);
				temp.add(arr[i]);
				res.add(temp);
				if (sum(temp) == target) {
					System.out.print("yes");
					System.out.print("(" + target + "=");
					for (int k = 0; k < temp.size() - 1; k++) {
						System.out.print(temp.get(k) + "+");
					}
					System.out.println(temp.get(temp.size() - 1) + ")");
					res.remove(r);
				}
			}
		}

	}

	private static int sum(List<Integer> r) {
		int sum = 0;
		for (int i : r) {
			sum += i;
		}
		return sum;
	}

	static List<Integer> res = new ArrayList<>();
	static int k;
	public static void dfs(int[] arr, int k, int cur) {
		if (k == 0) {
			System.out.print("yes(" + Test2_部分和.k + "=");
			for (int i = 0; i < res.size() - 1; i++) {
				System.out.print(res.get(i) + "+");
			}
			System.out.println(res.get(res.size() - 1) + ")");
			return;
		}
		if (k < 0 || cur == arr.length) {
			return;
		}
		dfs(arr, k, cur + 1); // 不要当前数
		
		res.add(arr[cur]);
		int index = res.size() - 1;
		dfs(arr, k - arr[cur], cur + 1); // 要当前数
		res.remove(index); // 回溯
	}
}
