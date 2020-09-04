package qinkai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.dao.StuDao;
import qinkai.dao.impl.StuDaoImpl;
import qinkai.dao.impl.UserDaoImpl;
import qinkai.domain.Student;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		boolean isSuccess = new UserDaoImpl().login(userName, password);
		
		if (isSuccess) {
			response.getWriter().write("登录成功.");
			StuDao stuDao = new StuDaoImpl();
			List<Student> list = stuDao.findAll();
			
			request.getSession().setAttribute("list", list);
			
			// 重定向
			response.sendRedirect("stu_list.jsp");
		} else {
			response.getWriter().write("登录失败,用户名或密码错误！");
		}

		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
