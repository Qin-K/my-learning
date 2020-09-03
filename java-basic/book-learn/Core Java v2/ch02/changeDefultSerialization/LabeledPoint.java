package changeDefultSerialization;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * Point2D.Double不可序列化，通过标记transient序列化
 * @author Qin-Kai
 *
 */
public class LabeledPoint implements Serializable{
	private String label;
	private transient Point2D.Double point;// 标记为transient
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Point2D.Double getPoint() {
		return point;
	}
	public void setPoint(Point2D.Double point) {
		this.point = point;
	}
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeDouble(point.getX());
		out.writeDouble(point.getY());
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		double x = in.readDouble();
		double y = in.readDouble();
		point = new Point2D.Double(x, y);
	}

}
