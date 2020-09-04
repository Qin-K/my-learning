package qinkai.test02;

public class GoogleCar implements ICar {

	@Override
	public void start() {
		System.out.println("汽车启动");
	}

	@Override
	public void run() {
		System.out.println("汽车运行");
	}

	@Override
	public void stop() {
		System.out.println("汽车停止");
	}

}
