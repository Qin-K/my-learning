package ch15;

public class TestSync implements Runnable {

	private int balance;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSync job = new TestSync();
		Thread a = new Thread(job);
		Thread b = new Thread(job);
		
		a.start();
		b.start();
	}
	public void run() {
		for (int i = 0; i < 50; i++) {
			increment();
			System.out.println("balance is " + balance);
		}
	}
	public synchronized void increment() {
		int i = balance;
		balance = i + 1; 
	}

}
