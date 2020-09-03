package qinkai.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestServletListener implements ServletRequestListener {
	public void requestDestroyed ( ServletRequestEvent sre ) {
		System.out.println("ServletRequest 创建了");
	}
	
	public void requestInitialized ( ServletRequestEvent sre ) {
		System.out.println("ServletRequest 销毁了");
	}
}
