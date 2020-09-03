package qinkai.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.domain.Student;
import qinkai.service.StudentService;
import qinkai.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			// 1. 获取数据
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			// 2. 调用Service查询
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.searchStudent(sname, gender);
			// 存放数据
			request.setAttribute("list", list);
			// 3. 跳转页面 
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
