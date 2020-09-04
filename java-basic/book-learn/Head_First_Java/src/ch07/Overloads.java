package ch07;

public class Overloads {
	public static int addNums(int a, int b) {
		return a + b;
	}
	public static double addNums(double a, double b) {
		return a + b;
	}
	public static void main(String[] args) {
		System.out.println(addNums(3, 5));
		System.out.println(addNums(3.3, 5.5));
		
		
	}
}
