package qinkai.spring.demo1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import qinkai.spring.domain.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JDBCDemo2 {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void demo2() {
        jdbcTemplate.update("insert into account values(null, ?, ?)", "李四", 10000d);
    }

    @Test
    // 统计查询
    public void demo3() {
        Long cnt = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(cnt);
    }

    @Test
    // 查询数据封装到对象
    public void demo4() {
        Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new MyRowMapper(), 1);
        System.out.println(account);

    }

    @Test
    // 查询数据封装到列表
    public void demo5() {
        List<Account> list = jdbcTemplate.query("select * from account", new MyRowMapper());
        for (Account account : list) {
            System.out.println(account);
        }
    }

    class MyRowMapper implements RowMapper<Account> {

        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setName(rs.getString("name"));
            account.setMoney(rs.getDouble("money"));
            return account;
        }
    }
}
