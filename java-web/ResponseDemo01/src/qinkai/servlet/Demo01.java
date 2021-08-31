package qinkai.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo01
 */
public class Demo01 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		test01(response);
		
		// test02(response); 
	}

	private void test02(HttpServletResponse response) throws IOException {
		// 使用字节流输出，默认使用UTF-8编码 
		response.getOutputStream().write("你好、世界".getBytes());
		response.setContentType("text/html; charset=UTF-8");
	}

	private void test01(HttpServletResponse response) throws IOException {
		// 通过字符流getWriter() 输出----> 乱码
		response.setContentType("text/html; charset=UTF-8"); 
		
		/*// 指定输出到客户端时使用UTF-8编码
		response.setCharacterEncoding("UTF-8");
		
		// 指定浏览器用UTF-8编码解析收到的数据
		response.setHeader("Content-Type", "text/html;charset=UTF-8");*/
		response.getWriter().println("你好，世界!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
