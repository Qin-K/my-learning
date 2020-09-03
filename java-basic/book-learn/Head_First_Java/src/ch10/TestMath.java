package ch10;
//MathµÄ·½·¨
public class TestMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double r1 = Math.random();
		int r2 = (int)(Math.random()*5);
		
		System.out.println("r1 = " + r1 + "\t" + "r2 = " + r2);
		
		int x1 = Math.abs(-240);
		double x2 = Math.abs(240.45);
		System.out.println("x1 = " + x1 + "\t" + "x2 = " + x2);
		
		int y1 = Math.round(-24.8f);
		int y2 = Math.round(24.24f);
		System.out.println("y1 = " + y1 + "\t" + "y2 = " + y2);
		
		int z1 = Math.min(24, 240);
		double z2 = Math.min(90876.5, 90876.49);
		System.out.println("min1 = " + z1 + "\t" + "min2 = " + z2);
		
		int m1 = Math.max(24, 240);
		double m2 = Math.max(98765.5, 98765.49);
		System.out.println("max1 = " + m1 + "\t" + "max2 = " + m2);
	}

}
