package 算法很美.ch3查找与排序.递归基础;

public class Test8_汉诺塔 {
	public static void main(String[] args) {
		hanio('A', 'B', 'C', 5);
	}
	
	public static void hanio(char a, char b, char c, int n) {
		if (n == 1) {
			System.out.println(a + "-->" + b);
		} else {
			hanio(a, c, b, n - 1);
			System.out.println(a + "-->" + b);
			hanio(c, b, a, n - 1);
		}
	}
}
