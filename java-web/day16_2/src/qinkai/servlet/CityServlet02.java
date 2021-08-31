package qinkai.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import qinkai.dao.CityDao;
import qinkai.dao.impl.CityDaoImpl;
import qinkai.domain.City;

/**
 * Servlet implementation class CityServlet
 */
@SuppressWarnings("serial")
public class CityServlet02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int pid = Integer.parseInt(request.getParameter("pid"));
			CityDao dao = new CityDaoImpl();
			List<City> list = dao.findCity(pid);
			JSONArray jsonArray = JSONArray.fromObject(list);
			String json = jsonArray.toString();
			response.setContentType("text/json;charset=UTF-8");
			response.getWriter().write(json);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
