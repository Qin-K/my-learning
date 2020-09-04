package 算法很美.ch3查找与排序.递归基础;

public class Test2_打印i_j {
	public static void main(String[] args) {
		f(2, 10);
	}
	
	public static void f(int i, int j) {
		if (i > j) {
			return;
		}
		System.out.println(i);
		f(i+1, j);
	}
}
