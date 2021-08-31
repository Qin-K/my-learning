package pair3;

public class Manager extends Employee{
	private double bonus;
	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		// TODO Auto-generated constructor stub
		bonus = 0;
	}
	
	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getBonus() {
		return bonus;
	}
}
