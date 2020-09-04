package 算法很美.ch3查找与排序.递归基础;

public class Test6_最大公约数 {
	public static void main(String[] args) {
		System.out.println(f(6, 24));
	}
	
	public static int f(int m, int n) {
		if (m % n == 0) {
			return n;
		}
		return f(n, m % n);
	}
}
