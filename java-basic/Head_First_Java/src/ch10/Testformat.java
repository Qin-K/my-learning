package ch10;

import java.util.Date;

public class Testformat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(String.format("%,d", 1000000000));
		System.out.println(String.format("I hava %.2f bugs to fix", 476578.09876));
		
		System.out.println(String.format("%x", 42));
		System.out.println(String.format("%c", 42));
		
		System.out.println(String.format("%tc", new Date()));
		System.out.println(String.format("%tr", new Date()));
		
		Date today = new Date();
		System.out.println(String.format("%tA, %tB, %td", today, today, today));
		System.out.println(String.format("%tA, %<tB, %<td", today));
	}

}
