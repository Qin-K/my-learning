package pair3;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
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
	
	public boolean equals(Object otherObject) {
		
		// �ж����������ǲ����������Զ����ǿ϶����
		if (this == otherObject) return true;
		
		// ���otherObjectΪ����϶�����ͬ
		if (otherObject == null) return false;
		
		// �ж����������Ƿ�������һ��
		if (getClass() != otherObject.getClass()) return false;
		
		// ת����Employee����н�һ���ж�
		Employee other = (Employee)otherObject;
		
		// �ж�ÿ�������ʵ��
		return Objects.equals(name, other.name)
			&& salary == other.salary
			&& Objects.equals(hireDay, other.hireDay);
		
	}
	public int hashCode() {
		return Objects.hash(name, salary, hireDay);	
	}
	public String toString() {
		return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay +"]"; 
	}
	
}
