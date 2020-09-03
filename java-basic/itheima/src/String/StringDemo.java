package String;

public class StringDemo {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = "hello";
		String s3 = "hello";
		String s4 = "Hello";
		
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
		System.out.println(s3.equals(s4));
		System.out.println(s3.equalsIgnoreCase(s4));
		
		System.out.println(s1.startsWith("hel"));
	}

}
