package 算法很美.ch7深入递归.递归;

import java.util.HashSet;
import java.util.Set;

public class Test4__集合的非空子集 {
	public static void main(String[] args) {
		Set<Character> set = new HashSet<>();
		set.add('A');
		set.add('B');
		set.add('C');
		
		System.out.println(f4(set));
	}
	// 集合的所有非空子集合
	public static Set<Set<Character>> f4(Set<Character> set) {
		Set<Set<Character>> res = new HashSet<>();
		Set<Character> e = new HashSet<>();
		res.add(e);
		for (char c : set) {
			Set<Set<Character>> help = new HashSet<>(res);
			for (Set<Character> s : help) {
				Set<Character> temp = new HashSet<>(s);
				temp.add(c);
				res.add(temp);
			}
		}
		res.remove(e);
		return res;
	}
}
