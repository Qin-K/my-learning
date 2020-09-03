package qinkai.test;
/**
 * 通过使用装饰着模式对GoogleCar功能增强
 * @author Qin-Kai
 */
public class MyCar implements ICar {
	ICar car;
	public MyCar(ICar car) {
		this.car = car;
	}
	@Override
	public void start() {
		System.out.println("检查路况是否良好");
		System.out.println("检查天气是否良好");
		car.start();
	}
	@Override
	public void run() {
		car.run();
	}
	@Override
	public void stop() {
		car.stop();
	}
	
}
