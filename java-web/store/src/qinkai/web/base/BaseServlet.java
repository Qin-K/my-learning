package qinkai.web.base;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method == null || method.equals("") || method.trim().equals("")) {
			method = "execute";
		}
		Class clazz = this.getClass();
		try {
			Method md = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			if (md != null) {
				String jspPath = (String) md.invoke(this, request, response);
				request.getRequestDispatcher(jspPath).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
}
