package 算法很美.ch7深入递归.递归;

import java.util.HashSet;
import java.util.Set;

public class Test3_合法括号 {
	public static void main(String[] args) {
		System.out.println(f31(3));
	}
	
	
	// 合法括号
	public static Set<String> f31(int n) {
		Set<String> set = new HashSet<>();
		if (n == 0) return set;
		if (n == 1) {
			set.add("()");
			return set;
		}
		Set<String> temp = f31(n - 1);
		for (String s : temp) {
			set.add("()" + s);
			set.add(s + "()");
			set.add("(" + s + ")");
		}
		
		return set;
	}
	
	public static Set<String> f32(int n) {
		Set<String> set = new HashSet<>();
		set.add("()");
		for (int i = 2; i <= n; i++) {
			Set<String> temp = new HashSet<>();
			for (String s : set) {
				temp.add("()" + s);
				temp.add(s + "()");
				temp.add("(" + s + ")");
			}
			set = temp;
		}
		
		return set;
	}
	
}
