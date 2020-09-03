package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 工具类
 * @author Qin-Kai
 *
 */
public class CollectionsTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		// static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) 
		// 使用二分搜索法搜索指定列表，以获得指定对象。
		int index = Collections.binarySearch(list, 4);
		System.out.println(index);
		
		// static <T> void  copy(List<? super T> dest, List<? extends T> src) 将所有元素从一个列表复制到另一个列表。 
		// 目标列表的长度至少必须等于源列表。如果目标列表更长一些，也不会影响目标列表中的其余元素。
		List<Integer> dest = new ArrayList<Integer>();
		dest.add(0);
		dest.add(0);
		dest.add(0);
		dest.add(0);
		
		Collections.copy(dest, list);
		System.out.println(dest);
		
		// static <T> void fill(List<? super T> list, T obj) 
        // 使用指定元素替换指定列表中的所有元素。 
		Collections.fill(dest, 4);
		System.out.println(dest);
		
		// static void reverse(List<?> list) 
		// 反转指定列表中元素的顺序。
		Collections.copy(dest, list);
		Collections.reverse(dest);
		System.out.println(dest);
		
		// static void shuffle(List<?> list) 
		// 使用默认随机源对指定列表进行置换。
		Collections.shuffle(dest);
		System.out.println(dest);
		
		// static <T> void sort(List<T> list, Comparator<? super T> c)  
		// 根据指定比较器产生的顺序对指定列表进行排序。
		Collections.sort(dest);
		System.out.println(dest);
		
		// static void swap(List<?> list, int i, int j) 
		// 在指定列表的指定位置处交换元素。
		Collections.swap(dest, 0, 3);
		System.out.println(dest);
	}

}
