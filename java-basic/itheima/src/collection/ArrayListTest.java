package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		Collection array = new ArrayList();
		array.add("hello");
		array.add("world");
		
		Iterator t = array.iterator();
		
		while (t.hasNext()) {
			String str = t.next().toString();
			System.out.println(str);
		}
	}

}
