package qinkai.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置请求体里面文字编码， 如果是get请求没有用
		request.setCharacterEncoding("UTF-8");
		// 获取所有参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username=" + username + "  password=" + password);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
