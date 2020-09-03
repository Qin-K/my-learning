package servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextDemo03
 */
public class ServletContext03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*test01();*/
		/*	test02();*/
		
		test03();
		
		
	}

	// 根据类加载器获取classes路径，然后找到资源文件所在的路径
	private void test03() throws IOException {
		Properties properties = new Properties();
		// 获取当前类，再获取加载类到虚拟机中的类对象
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("../../file/config.properties");		
		properties.load(is);
		
		String name = properties.getProperty("name");
		System.out.println("name = " + name);
	}
	
	// 根据相对路径直接获取流对象
	private void test02() throws IOException {
		Properties properties = new Properties();
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream("file/config.properties");
		
		properties.load(is);
		
		String name = properties.getProperty("name");
		System.out.println("name = " + name);
	}
	
	// 根据context获取绝对路径，在获取流对象
	private void test01() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		ServletContext context = getServletContext();
		String path = context.getRealPath("file/config.properties");
		System.out.println(path);
		
		InputStream is = new FileInputStream(path);
		properties.load(is);
		
		String name = properties.getProperty("name");
		System.out.println("name = " + name);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
