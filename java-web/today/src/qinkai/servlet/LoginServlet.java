package qinkai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.dao.impl.UserDaoImpl;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		boolean isSuccess = new UserDaoImpl().login(userName, password);
		
		if (isSuccess) {
			response.getWriter().write("登录成功.");

			request.getSession().setAttribute("username", userName );

			request.getRequestDispatcher("SentenceListServlet").forward(request, response);;
		} else {
			response.getWriter().write("登录失败,用户名或密码错误！");
		}

		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
