package 算法很美.ch6数学问题;

import java.util.HashMap;
import java.util.Map;

public class Test09_素数测试和因式分解 {
	public static void main(String[] args) {
//		System.out.println(isPrime(19));
		System.out.println(primeFactor(100));
		Map<Integer, Integer> map = primeFactor(100);
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int k = entry.getKey();
			int v = entry.getValue();
			
			for (int i = 0; i < v; i++) {
				sb.append("*" + k);
			}
		}
		
		System.out.println(sb.toString().substring(1));
	}
	
	public static boolean isPrime(int n) {
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static Map<Integer, Integer> primeFactor(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			while (n % i == 0) {
				Integer v = map.get(i);
				if (v == null) {
					map.put(i, 1);
				} else {
					map.put(i, v + 1);
				}
				
				n /= i;
			}
		}
		
		return map;
	}
}
