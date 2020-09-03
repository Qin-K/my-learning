package qinkai.test02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过动态代理对GoogleCar进行增强
 * @author Qin-Kai
 */
public class TestCar {

	public static void main(String[] args) {
		ICar car = (ICar) Proxy.newProxyInstance(TestCar.class.getClassLoader(), GoogleCar.class.getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (method.getName().equals("start")) {
					System.out.println("检查路况是否良好");
					System.out.println("检查天气是否良好");
				}
				method.invoke(new GoogleCar(), args);
				return null;
			}
		});
		car.start();
		car.run();
		car.stop();
	}

}
