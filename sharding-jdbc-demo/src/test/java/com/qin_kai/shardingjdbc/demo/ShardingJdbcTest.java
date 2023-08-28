package com.qin_kai.shardingjdbc.demo;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author qinkai
 * @date 2023/8/28
 */
@SpringBootTest
class ShardingJdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testInsert() {
        String insertSql = "insert into t(id,name) values(?,?)";
        for (int i = 1; i <= 100; i++) {
            jdbcTemplate.update(insertSql, i, "test" + i);
            System.out.println("insert " + i + " success");
        }
    }

    @Test
    void testQuery() {
        String querySql = "select * from t where id = 1";
        long start = System.currentTimeMillis();
        List<Map<String, Object>> result = jdbcTemplate.query(querySql, (rs, rowNum) ->
                ImmutableMap.of("id", rs.getInt("id"), "name", rs.getString("name"))
        );
        System.out.println(result + ", cost:" + (System.currentTimeMillis() - start));
    }

}
