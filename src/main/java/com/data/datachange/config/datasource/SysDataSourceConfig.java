package com.data.datachange.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author lz
 * 2018/5/29 11:27
 */
@Configuration
@MapperScan(basePackages = SysDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sysSqlSessionFactory")
public class SysDataSourceConfig {

     static final String PACKAGE = "com.data.datachange.module.**.mapper.sys";
     private static final String MAPPER_LOCATION = "classpath:mapper/sys/*Mapper.xml";

    @Value("${spring.sys.datasource.url}")
    private String url;

    @Value("${spring.sys.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.sys.datasource.username}")
    private String username;

    @Value("${spring.sys.datasource.password}")
    private String password;

    /**
     * 配置数据源
     *
     * @return sysDataSource
     */
    @Bean(name = "sysDataSource")
    @Primary
    public DataSource sysDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 配置事务管理器
     *
     * @return sysTransactionManager
     */
    @Bean(name = "sysTransactionManager")
    @Primary
    public DataSourceTransactionManager sysTransactionManager() {
        return new DataSourceTransactionManager(sysDataSource());
    }

    /**
     * 配置会话工厂
     *
     * @return sysSqlSessionFactory
     * @throws Exception 异常
     */
    @Bean(name = "sysSqlSessionFactory")
    @Primary
    public SqlSessionFactory sysSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(sysDataSource());
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return factoryBean.getObject();
    }
}
