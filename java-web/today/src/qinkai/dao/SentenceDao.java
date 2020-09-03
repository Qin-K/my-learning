package qinkai.dao;

import java.util.List;

import qinkai.domain.Sentence;

public interface SentenceDao {

	List<Sentence> findAll();
	void insert(Sentence sentence);
}
