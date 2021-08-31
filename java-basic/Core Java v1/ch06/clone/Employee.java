package clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable {
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
		hireDay = new Date();
	}
	public Employee clone() throws CloneNotSupportedException{
		Employee cloned = (Employee)super.clone();
		
		cloned.hireDay = (Date)hireDay.clone();
		return cloned;
	}
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public void setHireDay(int year, int month, int day) {
		Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
		
		hireDay.setTime(newHireDay.getTime());
	}
	
	public String toString() {
		return "Employee[name=" + name + ", salary=" + salary + ",hireDay=" + hireDay + "]";
	}
}