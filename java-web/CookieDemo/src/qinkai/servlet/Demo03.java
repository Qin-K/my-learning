package qinkai.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.util.CookieUtil;

public class Demo03 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		// 判断是否登录成功
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if ("admin".equals(username) && "123".equals(password)) {
			// 登录成功
			Cookie[] cookies = request.getCookies();
			Cookie c = CookieUtil.findCookie(cookies, "last");
			// 判断是否第一次登录
			if (c == null) {
				// 第一次登录
				// 添加Cookie, 表示登录时间
				Cookie cookie = new Cookie("last", System.currentTimeMillis() + "");
				cookie.setMaxAge(60 * 60);
				response.addCookie(cookie);
				response.getWriter().write("欢迎你," + username);
			} else {
				// 第二次登录 
				// 打印上次登录时间
				System.out.println(c);
				// 更新Cookie中的时间
				c.setValue(System.currentTimeMillis() + "");
				response.addCookie(c);
				response.getWriter().write("欢迎你," + username + " " + new Date(Long.parseLong(c.getValue())));
			}
		} else {
			// 登录失败
			response.getWriter().write("登录失败！！");
		}
			
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
