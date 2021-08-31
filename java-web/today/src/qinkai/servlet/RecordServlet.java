package qinkai.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qinkai.dao.SentenceDao;
import qinkai.dao.impl.SentenceDaoImpl;
import qinkai.domain.Sentence;

/**
 * Servlet implementation class RecordServlet
 */
public class RecordServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 获取提交的数据
		String mood = request.getParameter("mood");
		String weather = request.getParameter("weather");
		String info = request.getParameter("info");
		String uName = (String) request.getSession().getAttribute("username");
		// 储存到数据库
		Sentence sentence = new Sentence(new Date(), weather, mood, info, uName);
		SentenceDao dao = new SentenceDaoImpl();
		dao.insert(sentence);
		
		// 跳转页面
		request.getRequestDispatcher("SentenceListServlet").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
