package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter writer = response.getWriter();
		if (username.equals("admin") && password.equals("123")) {
			// writer.println("login success...");
			
			// 设置重定向 状态码 302
			response.setStatus(302);
			
			// 取出以前所有登录中总数
			Object obj = getServletContext().getAttribute("count");
			
			System.out.println(obj);
			int totalCount = 0;
			if (obj != null) {
				totalCount = (int)obj;
			}
			// System.out.println("登录总数=" + count);
			// 存入登录总数
			getServletContext().setAttribute("count", ++totalCount);
			response.setHeader("Location", "login_success.html");
		} else {
			writer.println("login failed...");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
