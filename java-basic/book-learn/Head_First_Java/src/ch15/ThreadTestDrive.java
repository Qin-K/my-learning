package ch15;

public class ThreadTestDrive {
	public static void main(String[] args) {
		Runnable threadJob = new MyRunnable();
		Thread myThread = new Thread(threadJob);
		
		myThread.run();
		
		System.out.println("back in main");
	}
}
