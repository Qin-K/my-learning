package qinkai.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.domain.Student;
import qinkai.service.impl.StudentServiceImpl;

public class UpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			
			// 1. 获取客户端提交上来的数据
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname"); 
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday"); // 1989-10-18
			// String hobby = request.getParameter("hobby");
			String info = request.getParameter("info");
			String[] h = request.getParameterValues("hobby");
			String hobby = Arrays.toString(h);
			hobby = hobby.substring(1, hobby.length() - 1);
			// 2.添加到数据库
			// 将birthday字符串类型转换成Data类型
			Date date= new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			Student student = new Student(sid, sname, gender, phone, hobby, info, date);
			new StudentServiceImpl().update(student);
			// 3.跳转页面 
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
