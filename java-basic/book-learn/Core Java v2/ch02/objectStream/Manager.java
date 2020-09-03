package objectStream;

import java.io.Serializable;

public class Manager extends Employee {
	private double bonus;
	private Employee secretary;
	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bonus = 0;
	}
	
	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public void setSecretary(Employee s) {
		secretary = s;
	}
	public String toString() {
		return super.toString() + "|" + secretary.getName();
	}
	
}
