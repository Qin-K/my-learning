package serialClone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
public class SerialCloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee harry = new Employee("Harry Hacker", 35000, 1989, 10, 1);
		
		// 克隆harry
		Employee harry2 = (Employee) harry.clone();
		
		harry.raiseSalary(10);
		
		System.out.println(harry);
		System.out.println(harry2);
	}

}
class SerialCloneable implements Cloneable, Serializable{

	public Object clone() throws CloneNotSupportedException {
		try {
			// 保存对象到byte数组
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			try ( ObjectOutputStream out = new ObjectOutputStream(bout)){
				out.writeObject(this);
			}
			
			// 从数组里面克隆一个对象
			try (ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray())){
				ObjectInputStream in = new ObjectInputStream(bin);
				return in.readObject();
			} 
		} catch(IOException | ClassNotFoundException e) {
			CloneNotSupportedException e2 = new CloneNotSupportedException();
			e2.initCause(e);
			throw e2;
		}
	}
}


class Employee extends SerialCloneable {
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		hireDay = LocalDate.of(year, month, day);
	}
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	public LocalDate getHireDay() {
		return hireDay;
	}
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	public String toString() {
		return name + "|" + salary + "|" + hireDay;
	}
}