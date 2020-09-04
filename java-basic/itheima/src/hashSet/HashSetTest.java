package hashSet;

import java.util.HashSet;

/**
 * 通过重写hashCode和equals方法实现自定义对象的去重
 * @author Qin-Kai
 *
 */
public class HashSetTest {

	public static void main(String[] args) {
		HashSet<Student> hs = new HashSet<Student>();
		hs.add(new Student("小明", 19));
		hs.add(new Student("小王", 19));
		hs.add(new Student("小王", 19));
		
		for (Student s : hs) {
			System.out.println(s);
		}
	}

}

class Student{
	private String name;
	private int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Student s = (Student)obj;
		if (!this.name.equals(s.name) || this.age != s.age) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
	
	
}