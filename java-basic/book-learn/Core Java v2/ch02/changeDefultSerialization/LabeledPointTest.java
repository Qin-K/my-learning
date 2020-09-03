package changeDefultSerialization;

import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LabeledPointTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		LabeledPoint lp = new LabeledPoint();
		lp.setLabel("hello");
		lp.setPoint(new Point2D.Double(1.0, 1.0));
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("lp.dat"));
		out.writeObject(lp);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("lp.dat"));
		LabeledPoint newlp = (LabeledPoint) in.readObject();
		
		System.out.println(newlp.getLabel());
		System.out.println(newlp.getPoint().getX() + "," + newlp.getPoint().getY());
	}
}
