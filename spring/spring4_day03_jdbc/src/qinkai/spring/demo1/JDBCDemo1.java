package qinkai.spring.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCDemo1 {

    @Test
    public void demo1() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://:3306/spring4_day03_jdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into account values(null, ?, ?)", "张三", 10000d);
    }
}
