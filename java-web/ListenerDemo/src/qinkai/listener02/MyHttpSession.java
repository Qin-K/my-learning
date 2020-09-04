package qinkai.listener02;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSession implements HttpSessionAttributeListener {
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("Session 属性被添加");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("Session 属性被删除");
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("Session 属性被替换了");
	}
}
