package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo01
 */
public class Demo01 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		// 获取所有request头信息  --- 保存为枚举集合
		Enumeration<String> headerNames = request.getHeaderNames();
		
		// 遍历
		while (headerNames.hasMoreElements()) {
			// 得到key
			String headerName = headerNames.nextElement();
			// 得到value
			String value = request.getHeader(headerName);
			
			System.out.println(headerName + " : " + value);
		}*/
		
		// 获取单个参数
		String name = request.getParameter("username");
		String address = request.getParameter("address");
		
		System.out.println("username=" + name + "   address=" + address);
		
		// 获取所有参数
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String string = (String) parameterNames.nextElement();
			String value = request.getParameter(string);
			System.out.println(string + ":" + value);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
