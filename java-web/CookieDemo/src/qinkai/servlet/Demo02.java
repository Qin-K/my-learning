package qinkai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				String cookieValue = cookie.getValue();
				
				System.out.println(cookieName + ":" + cookieValue);
			}
		}
		
		// 添加cookie
		Cookie cookie1 = new Cookie("name", "zhangsan");
		// setMaxAge: 设置最大有效时间，单位秒 、负值表示当浏览器关闭时cookie失效 默认值-1
		cookie1.setMaxAge(60 * 60 * 24 * 7);
		response.addCookie(cookie1);
		 
		Cookie cookie2 = new Cookie("age", "18");
		response.addCookie(cookie2);
		
		response.getWriter().write("请求成功!!!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
