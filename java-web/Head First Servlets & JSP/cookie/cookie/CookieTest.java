package cookie;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CookieTest extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
						throws IOException, ServletException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		// 得到表单中提交的用户名
		String name = request.getParameter("username");
		// 建立一个Cookie用来存放用户名
		Cookie cookie = new Cookie("username", name);
		// 在客户端上存活30分钟
		cookie.setMaxAge(30*60);
		
		// 将Cookie作为响应首部返回
		response.addCookie(cookie);
		// JSP建立响应界面
		RequestDispatcher view = request.getRequestDispatcher("cookieresult.jsp");
		view.forward(request, response);
	}
}
