package ch10;

public class Duck {
	private int size;
	private static int duckCount = 0;
	public Duck() {
		duckCount++;
	}
	public void getCount() {
		System.out.println(duckCount);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck d1 = new Duck();
		Duck d2 = new Duck();
		Duck d3 = new Duck();
		
		d1.getCount();
		d2.getCount();
		d3.getCount();
	}
	

}
