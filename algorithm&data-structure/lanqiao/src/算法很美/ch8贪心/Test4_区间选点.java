package 算法很美.ch8贪心和动态规划.贪心;

import java.util.Arrays;
import java.util.Scanner;

public class Test4_区间选点 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Interval[] intervals = new Interval[n];
		for (int i = 0; i < n; i++) {
			intervals[i] = new Interval(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		int max = max(intervals);
		rec = new int[max + 1];
		Arrays.sort(intervals);
		
		int res = f(intervals);
		System.out.println(res);
	}


	static int[] rec;
	private static int f(Interval[] intervals) {
		int res = 0;
		int n = intervals.length;
		for (int i = 0; i < n; i++) {
			int cnt = sum(intervals[i]);
			int c = intervals[i].cnt - cnt; // 需要打点的数目
			int t = intervals[i].end; // 从末尾开始打点
			while (c > 0) {
				if (rec[t] == 0) {
					rec[t] = 1;
					c--;
					res++;
				}
				t--;
			}
		}
		
		return res;
	}
	
	private static int sum(Interval interval) {
		int cnt = 0;
		for (int i = interval.start; i <= interval.end; i++) {
			if (rec[i] == 1) cnt++; 
		}
		return cnt;
	}

	private static int max(Interval[] intervals) {
		int max = intervals[0].end;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].end > max) {
				max = intervals[i].end;
			}
		}
		return max;
	}
}

class Interval implements Comparable<Interval>{
	int start;
	int end;
	int cnt;
	public Interval(int start, int end, int cnt) {
		super();
		this.start = start;
		this.end = end;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Interval o) {
		return this.end - o.end;
	}
}
