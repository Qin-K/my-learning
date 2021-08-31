package cookie;
import javax.security.sasl.SaslException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CheckCookie extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws IOException, ServletException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("username")) {
					String userName = cookie.getValue();
					out.println("Hello " + userName);
					break;
				}
			}
		}
	}

}
