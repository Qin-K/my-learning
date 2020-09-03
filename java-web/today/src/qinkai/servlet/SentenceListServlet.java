package qinkai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.dao.SentenceDao;
import qinkai.dao.impl.SentenceDaoImpl;
import qinkai.domain.Sentence;

/**
 * Servlet implementation class SentenceListServlet
 */
public class SentenceListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SentenceDao stuDao = new SentenceDaoImpl();
		List<Sentence> list = stuDao.findAll();
		request.getSession().setAttribute("list", list);
		
		response.sendRedirect("sentence_list.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
