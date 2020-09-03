package 算法很美.ch1位运算;
import java.util.Scanner;

/**
 * 整数部分模2取余，逆序。
 * 小数部分乘2，依次取整数部分。 
 * @author Qin-Kai
 *
 */

public class Test06_二进制表示实数 {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 double num = sc.nextDouble();
		 // 整数部分表示
		 StringBuilder sb = new StringBuilder("0.");
		 while (num != 0) {
			 num *= 2;
			 if (num >= 1) {
				 sb.append(1);
				 num = num % 1;
			 } else {
				 sb.append(0);
			 }
			 
			 if (sb.length() > 34) {
				 System.out.println("ERROR!");
				 return;
			 }
		 }
		 
		 String s = sb.toString();
		 System.out.println(s);
	}
}
