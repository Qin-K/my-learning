package 算法很美.ch8贪心和动态规划.贪心;

import java.util.Arrays;

public class Test8_部分背包 {
	static class Obj implements Comparable<Obj>{
		int w;
		int v;
		Obj(int w, int v) {
			this.w = w;
			this.v = v;
		}
		
		public double getPrice() {
			return 1.0 * v / w;
		}

		@Override
		public int compareTo(Obj o) {
			return Double.compare(this.getPrice(), o.getPrice());
		}
		
	}

	public static void main(String[] args) {
		int[] w = { 1, 2, 3, 4, 5 };
		int[] v = { 3, 4, 3, 1, 4 };
		double c = 10;
		int n = w.length;
		Obj[] objs = new Obj[n];
		for (int i = 0; i < n; i++) {
			objs[i] = new Obj(w[i], v[i]);
		}
		
		double res = f(objs, c);
		System.out.println(res);
	}

	private static double f(Obj[] objs, double c) {
		int n = objs.length;
		Arrays.sort(objs);
		double s = 0;
		double maxValue = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (s + objs[i].w <= c) {
				s += objs[i].w;
				maxValue += objs[i].v;
			} else {
				maxValue += (c - s) * objs[i].getPrice();
				break;
			}
		}
		
		return maxValue;
	}
	
}
