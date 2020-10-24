package com.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author qin kai
 * @date 2020/8/27
 */
@Configuration
@MapperScan(basePackages = {"com.example.mapper.test1"}, sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class DataSource1Config {

    @Bean("test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("test1SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mapper/test1/*.xml")); 指定mapper路径
        return bean.getObject();
    }

    @Bean("test1DataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("test1DataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("test1SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
