package qinkai.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Bean01 implements HttpSessionBindingListener{
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("对象被绑定了");
	}
	
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("对象被解绑定了");
	}
}
