package qinkai.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo01
 */
public class Demo01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Cookie cookie = new Cookie("aa", "bb");
		response.addCookie(cookie);
		
		response.getWriter().println("请求成功！");
		
		// 获取浏览器请求中的cookie
		Cookie[] cookies = request.getCookies();
		
		// 不是第一次请求为空
		if (cookies != null) {
			for (Cookie c : cookies) {
				String cookieName = c.getName();
				String cookieValue = c.getValue();
				
				System.out.println(cookieName + ":" + cookieValue);
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
