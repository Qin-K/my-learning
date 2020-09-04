package 算法很美.ch3查找与排序.递归基础;

public class Test1_求n的阶乘 {
	public static void main(String[] args) {
		System.out.println(f(10));
	}
	public static int f(int n) {
		if (n == 1) {
			return 1;
		}
		return n * f(n-1);
	}
}
