package 算法很美.ch8贪心和动态规划.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test3_区间调度 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Obj[] objs = new Obj[n];
		for (int i = 0; i < n; i++) {
			objs[i] = new Obj();
			objs[i].start = sc.nextInt();
			objs[i].id = i + 1;
		}
		
		for (int i = 0; i < n; i++) {
			objs[i].end = sc.nextInt();
		}
		
		Arrays.sort(objs);
		int ans = f(objs);
		System.out.println(ans);
		System.out.println(list);
	}

	static List<Integer> list = new ArrayList<>();
	private static int f(Obj[] objs) {
		if (objs == null || objs.length == 0) {
			return 0;
		}
		int n = objs.length;
		int cnt = 1;
		int y = objs[0].end;
		list.add(objs[0].id);
		for (int i = 1; i < n; i++) {
			if (objs[i].start >= y) {
				list.add(objs[i].id);
				cnt++;
				y = objs[i].end;
			}
		}
		return cnt;
	}
	
}

class Obj implements Comparable<Obj>{
	int id;
	int start;
	int end;
	@Override
	public int compareTo(Obj o) {
		return this.end - o.end;
	}
	@Override
	public String toString() {
		return start + "-" + end;
	}
}
