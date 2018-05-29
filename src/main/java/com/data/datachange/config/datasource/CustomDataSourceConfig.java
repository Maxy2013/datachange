package com.data.datachange.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author lz
 * 2018/5/29 14:17
 */
@Configuration
@MapperScan(basePackages = CustomDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "customSqlSessionFactory")
public class CustomDataSourceConfig {

    static final String PACKAGE = "com.data.datachange.module.**.mapper.custom";
    private static final String MAPPER_LOCATION = "classpath:mapper/custom/*Mapper.xml";

    @Value("${spring.custom.datasource.url}")
    private String url;

    @Value("${spring.custom.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.custom.datasource.username}")
    private String username;

    @Value("${spring.custom.datasource.password}")
    private String password;

    /**
     * 配置dataSource
     * @return dataSource
     */
    @Bean(name = "customDataSource")
    public DataSource customDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 配置事务管理器
     * @return customTransactionManager
     */
    @Bean(name = "customTransactionManager")
    public DataSourceTransactionManager customTransactionManager(){
        return new DataSourceTransactionManager(customDataSource());
    }

    /**
     * 配置会话工厂
     * @return customSqlSessionFactory
     * @throws Exception 异常
     */
    @Bean(name = "customSqlSessionFactory")
    public SqlSessionFactory customSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(customDataSource());
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return factoryBean.getObject();
    }

}
