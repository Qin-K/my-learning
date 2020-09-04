package qinkai.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.dao.UserDao;
import qinkai.dao.impl.UserDaoImpl;

public class CheckUserNameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			UserDao dao = new UserDaoImpl();
			boolean isExist = dao.checkName(name);
			if (isExist) {
				response.getWriter().println(1);
			} else {
				response.getWriter().println(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
