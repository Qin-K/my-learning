package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class listIterator {
	public static void main(String[] args) {
		List c = new ArrayList();
		
		c.add("hello");
		c.add("world");
		c.add("java");
		
		ListIterator lit = c.listIterator();
		
		while(lit.hasNext()) {
			String str = lit.next().toString();
			if (str.equals("java")) {
				lit.add("android"); // 用listIterater添加元素会同步List，用迭代器遍历的时候不能修改集合的值否则会并发异常。
			}
		}
		System.out.println(c);
	}
}
