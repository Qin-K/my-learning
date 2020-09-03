package 算法很美.ch1位运算;
import java.util.Scanner;

/**
 * 找出1-1000中唯一成对的数
 * 使用异或^ , 相同的两个数异或为0
 * @author Qin-Kai
 *
 */
public class Test01_找出数组中唯一成对元素 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int res = f(arr);
		System.out.println(res);
	}

	private static int f(int[] arr) {
		int n = arr.length;
		int res = 1;
		for (int i = 2; i <= n; i++) {
			res ^= i;
		}
		
		for (int i = 0; i < n; i++) {
			res ^= arr[i];
		}
		return res;
	}
	
}