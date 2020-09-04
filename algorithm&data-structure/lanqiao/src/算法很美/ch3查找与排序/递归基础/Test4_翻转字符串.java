package 算法很美.ch3查找与排序.递归基础;

public class Test4_翻转字符串 {
	public static void main(String[] args) {
		System.out.println(f("hello", 4));
	}
	
	public static String f(String s, int end) {
		if (end == 0) {
			return s.charAt(0) + "";
		}
		return s.charAt(end) + f(s, end - 1);
	}
}
