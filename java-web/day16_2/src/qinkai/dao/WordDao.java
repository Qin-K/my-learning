package qinkai.dao;

import java.sql.SQLException;
import java.util.List;

import qinkai.domain.Word;

public interface WordDao {
	List<Word> findWords(String word) throws SQLException;
}
