package 算法很美.ch6数学问题;

public class Test05_求逆元 {
	public static void main(String[] args) {
		// 13x=1(mod5)
//		Test05_拓展欧几里得算法_裴蜀公式.inverseElement(13, 5);
		// System.out.println(Test05_拓展欧几里得算法_裴蜀公式.x);
		
		// 12x = 1(mod2)
		int d = Test05_拓展欧几里得算法_裴蜀公式.inverseElement(12, 2);
		if (d == 0) {
			System.out.println("无解");
		} else {
			System.out.println(Test05_拓展欧几里得算法_裴蜀公式.x);
		}
	}
}
