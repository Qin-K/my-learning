package 算法很美.ch3查找与排序.递归基础;

public class Test5_斐波那契数列 {
	public static void main(String[] args) {
		System.out.println(f(10));
	}
	
	public static int f(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return f(n - 1) + f(n - 2);
	}
}
