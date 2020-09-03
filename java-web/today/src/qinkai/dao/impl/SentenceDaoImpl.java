package qinkai.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import qinkai.dao.SentenceDao;
import qinkai.domain.Sentence;
import qinkai.util.JDBCUtil;

public class SentenceDaoImpl implements SentenceDao {

	@Override
	public List<Sentence> findAll() {
		List<Sentence> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select * from t_sentence";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 遍历rs创建Student对象并添加到list中
			while (rs.next()) {
				Date date = rs.getDate("date");
				String weather = rs.getString("weather");
				String mood = rs.getString("mood");
				String info = rs.getString("info");
				String uName = rs.getString("uname");
				
				Sentence sentence = new Sentence(date, weather, mood, info, uName);
				list.add(sentence);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
		return list;
	}

	@Override
	public void insert(Sentence sentence) {
		List<Sentence> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "insert into t_sentence values(null,?, ?, ?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(sentence.getDate().getTime()));
			ps.setString(2, sentence.getWeather());
			ps.setString(3, sentence.getMood());
			ps.setString(4, sentence.getInfo());
			ps.setString(5, sentence.getuName());
			
			System.out.println(new java.sql.Date(sentence.getDate().getTime()));
			System.out.println(sentence.getWeather() + sentence.getMood() + sentence.getInfo() + sentence.getuName());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
	}

}
