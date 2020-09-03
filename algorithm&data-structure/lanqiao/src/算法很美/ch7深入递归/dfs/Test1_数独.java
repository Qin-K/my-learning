package 算法很美.ch7深入递归.dfs;

import java.util.Scanner;

public class Test1_数独 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] a = new char[9][9];
		for (int i = 0; i < 9; i++) {
			a[i] = sc.nextLine().toCharArray();
		}
		
		dfs(a, 0, 0);
	}
	
	public static void dfs(char[][] a, int x, int y) {
		if (x == 9) {
			print(a);
			System.exit(0);
		}
		
		if (a[x][y] == '0') {
			for (int i = 1; i <= 9; i++) {
				boolean isValid = check(a, x, y, i);
				if (isValid) {
					a[x][y]= (char)(i + '0');
					dfs(a, x + (y +1)/9, (y+1)%9);
					a[x][y] = '0'; // 回溯
				}
			}
		} else {
			dfs(a, x + (y +1)/9, (y+1)%9);
		}
	}

	private static void print(char[][] a) {
		for (int i = 0; i < 9; i++) {
			System.out.println(new String(a[i]));
		}
	}

	private static boolean check(char[][] a, int x, int y, int i) {
		 //检查同行和同列
	    for (int l = 0; l < 9; l++) {
	      if (a[x][l] == (char) ('0' + i)) return false;
	      if (a[l][y] == (char) ('0' + i)) return false;
	    }
	    //检查小九宫格
	    for (int l = (x / 3) * 3; l < (x / 3 + 1) * 3; l++) {
	      for (int m = (y / 3) * 3; m < (y / 3 + 1) * 3; m++) {
	        if (a[l][m] == (char) ('0' + i)) return false;
	      }
	    }
	    return true;
	}
}
