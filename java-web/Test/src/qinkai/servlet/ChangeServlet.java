package qinkai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.domain.Student;

public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student stu = (Student) request.getSession().getAttribute("stu");
		System.out.println(stu);
		String phone = (String) request.getSession().getAttribute("phone");
		if (phone == null) {
			phone = new String();
			request.getSession().setAttribute("phone", phone);
		}
		if (null == stu) {
			stu = new Student();
			request.getSession().setAttribute("stu", stu );
		}
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		phone = request.getParameter("phone");
		stu.setName(name);
		stu.setAge(age);
		
		response.sendRedirect("/Test/show.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
