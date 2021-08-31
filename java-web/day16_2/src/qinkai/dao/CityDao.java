package qinkai.dao;

import java.sql.SQLException;
import java.util.List;
import qinkai.domain.City;

public interface CityDao {
	List<City> findCity(int pid) throws SQLException;
}
