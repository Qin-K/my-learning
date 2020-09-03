package qinkai.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String[] names = {"iphon7", "小米6", "三星note8", "魅族7", "华为9"};
		
		String name = names[id];
		Map<String, Integer> map = (Map<String, Integer>)request.getSession().getAttribute("cart");
		
		if (map == null) {
			// 购物车为空
			map = new LinkedHashMap<String, Integer>();
			map.put(name, 1);
			request.getSession().setAttribute("cart", map);
		} else {
			// 判断购物车是否包含购买的商品
			if (map.containsKey(name)) {
				map.put(name, map.get(name) + 1);
			} else {
				map.put(name, 1);
			}
		}
		// 输出界面
		response.getWriter().write("<h3><a href='product_list.jsp'>继续购物</a></h3>");
		response.getWriter().write("<h3><a href='cart.jsp'>去购物车结算</a></h3>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
