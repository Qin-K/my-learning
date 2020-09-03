package randomAccess;

import java.time.LocalDate;

class Employee{
	public static final int NAME_SIZE = 40;
	public static final int RECORD_SIZE = 100;
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