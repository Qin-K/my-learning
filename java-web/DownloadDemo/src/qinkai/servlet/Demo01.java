package qinkai.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo01
 */
public class Demo01 extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取下载文件名 
		String filename = request.getParameter("filename");
		// 获取用户下载文件所在路径
		String path = getServletContext().getRealPath("download/" + filename);
		// 获取输入流
		InputStream is = new FileInputStream(path);
		
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		// 输出
		OutputStream os = response.getOutputStream();
		int len = 0;
		byte[] buffer = new byte[1024];
		while((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		
		is.close();
		os.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
