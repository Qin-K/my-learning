package qinkai.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import qinkai.dao.CityDao;
import qinkai.dao.impl.CityDaoImpl;
import qinkai.domain.City;

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int pid = Integer.parseInt(request.getParameter("pid"));
			CityDao dao = new CityDaoImpl();
			List<City> list = dao.findCity(pid);
			XStream xStream = new XStream();
			xStream.alias("city", City.class);
			String xml = xStream.toXML(list);
			System.out.println(xml);
			response.setContentType("text/xml;charset=UTF-8");
			response.getWriter().write(xml);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
