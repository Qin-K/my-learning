package qinkai.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.domain.Student;
import qinkai.service.StudentService;
import qinkai.service.impl.StudentServiceImpl;

public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int sid = Integer.parseInt(request.getParameter("sid"));
			StudentService service = new StudentServiceImpl();
			Student stu = service.findStudentById(sid);
			
			// 将学生信息储存到作用域
			request.setAttribute("stu", stu);
			// 跳转页面到edit.jsp
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
