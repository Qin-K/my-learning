package qinkai.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import qinkai.dao.WordDao;
import qinkai.domain.Word;
import qinkai.util.JDBCUtil02;

public class WordDaoImpl implements WordDao {

	@Override
	public List<Word> findWords(String word) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from words where word like ? limit ?";
		return runner.query(sql, new BeanListHandler<Word>(Word.class), word +"%", 5);
	}

}
