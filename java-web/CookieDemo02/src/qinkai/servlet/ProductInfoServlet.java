package qinkai.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.util.CookieUtil;

/**
 * Servlet implementation class ProductInfoServlet
 */
public class ProductInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtil.findCookie(cookies, "history");
		
		if (cookie == null) {
			// 第一次登陆
			Cookie c = new Cookie("history", id);
			c.setMaxAge(60 * 60 * 24 * 7);
			c.setPath("/CookieDemo02");
			response.addCookie(c);
		} else {
			cookie.setValue(cookie.getValue() + "#" + id);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			cookie.setPath("/CookieDemo02");
			response.addCookie(cookie);
		}
		
		response.sendRedirect("product_info.htm");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
