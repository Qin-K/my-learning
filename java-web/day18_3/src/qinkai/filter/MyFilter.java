package qinkai.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 使用动态代理对request的getParameter进行增强保证中文不会出现乱码问题。
 * @author Qin-Kai
 */
public class MyFilter implements Filter {
    public MyFilter() {
    }
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpServletRequest myReq = (HttpServletRequest)Proxy.newProxyInstance(MyFilter.class.getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object obj = null;
				if (method.getName().equals("getParameter")) {
					if (req.getMethod().equals("get")) {
						String str = (String)req.getParameter("username");
						obj = new String(str.getBytes("ISO-8859-1"), "UTF-8");
					} else {
						req.setCharacterEncoding("UTF-8");
						obj = method.invoke(req, args);
					}
				} else {
					obj = method.invoke(req, args);
				}
				return obj;
			}
		});
		System.out.println(myReq.hashCode());
		chain.doFilter(myReq, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
