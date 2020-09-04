package 算法很美.ch3查找与排序.ch3;

public class Test4_员工年龄排序 {
	public static void main(String[] args) {
		int[] A = {40, 23, 21, 89};
		f(A);
	}
	
	public static void f(int[] A) {
		int n = A.length;
		int[] help = new int[100];
		for (int i = 0; i < n; i++) {
			help[A[i]]++;
		}
		
		// 输出打印
		for (int i = 1; i < 100; i++) {
			while(help[i] != 0) {
				System.out.print(i + " ");
				help[i]--;
			}
		}
	}
}
