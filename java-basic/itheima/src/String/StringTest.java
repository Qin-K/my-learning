package String;

import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
		String id;
		String password;
		
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 3; i++) {
			System.out.println("请输入登录账号：");
			id = sc.nextLine();
			System.out.println("请输入登录密码");
			password = sc.nextLine();
			
			if (id.equals("123456") && password.equals("123456")) {
				System.out.println("登录成功");
				break;
			} else {
				System.out.println("账号或密码错误，请重新输入， 你还有" + (3 - i) + "次机会!");
			}
		}
	}

}
