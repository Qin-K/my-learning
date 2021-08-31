package abstractClasses;

public class Student extends Person {
	private String major;
	/**
	 * @param nama hte student's name
	 * @param major the student's major
	 */
	public Student(String name, String major) {
		super(name);
		this.major = major;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "a student majoring in " + major;
	}
	
}
