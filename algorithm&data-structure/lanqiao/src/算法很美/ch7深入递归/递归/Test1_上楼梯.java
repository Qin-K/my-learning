package 算法很美.ch7深入递归.递归;

public class Test1_上楼梯 {
	public static void main(String[] args) {
		System.out.println(f11(10));
		
	}
	
	
	// 上楼梯
	public static int f11(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		return f11(n - 1) + f11(n - 2) + f11(n - 3);
	}
	
	public static int f12(int n) {
		int x1 = 1;
		int x2 = 2;
		int x3 = 4;
		
		int result = 0;
		for (int i = 4; i <= n; i++) {
			result = x1 + x2 + x3;
			x1 = x2;
			x2 = x3;
			x3 = result;
		}
		
		return result;
	}
}
