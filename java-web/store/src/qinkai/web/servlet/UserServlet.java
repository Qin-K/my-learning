package qinkai.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.domain.User;
import qinkai.service.UserService;
import qinkai.service.UserServiceImpl;
import qinkai.util.MyBeanUtils;
import qinkai.util.UUIDUtils;
import qinkai.web.base.BaseServlet;

public class UserServlet extends BaseServlet {
	public String registUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsp/register.jsp";
	}

	public String loginUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsp/login.jsp";
	}

	public String userRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map = request.getParameterMap();
		User user = new User();
		MyBeanUtils.populate(user, map);
		user.setUid(UUIDUtils.getId());
		user.setState(0);
		user.setCode(UUIDUtils.getCode());
		UserService userService = new UserServiceImpl();
		userService.userRegist(user);
		request.setAttribute("msg", "注册成功，请登录！");
		return "/jsp/info.jsp";
	}
	
	public String userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userService = new UserServiceImpl();
		int flag = userService.userLogin(username, password);
		if (flag == 0) {
			// 密码不正确
			request.setAttribute("msg", "密码不正确！");
			return "/jsp/login.jsp";
		} else if (flag == 1) {
			// 未激活
			request.setAttribute("msg", "用户未激活！");
			return "/jsp/login.jsp";
		} else {
			// 登录成功
			response.sendRedirect("index.jsp");
			return null;
		}
	}

}
