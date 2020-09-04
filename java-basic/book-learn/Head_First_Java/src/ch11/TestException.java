package ch11;

class ScaryException extends Exception{
	
}
public class TestException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "no";
		try {
			System.out.println("start try");
			doRisky(test);
			System.out.println("end try");
		} catch (ScaryException se) {
			System.out.println("scary exception");
		} finally {
			System.out.println("finally");
		}
		System.out.println("end of main");
	}
	static void doRisky(String test) throws ScaryException {
		System.out.println();
		if ("yes".equals(test)) {
			throw new ScaryException();
		} 
		System.out.println("end risky");
		return;
	}
}
