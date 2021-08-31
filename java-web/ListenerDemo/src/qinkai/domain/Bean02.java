package qinkai.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Bean02 implements HttpSessionActivationListener, Serializable {
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 钝化
	 */
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("对象被钝化了");
	}
	/**
	 * 活化
	 */
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("对象被活化了");
	}
}
