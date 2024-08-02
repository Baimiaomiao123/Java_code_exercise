package com.baimiaomiao.bank;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Spring6Config
 * @since 1.0
 */

@Configuration //代替spring.xml文件
@ComponentScan("com.baimiaomiao.bank") //开启组件扫描
@EnableTransactionManagement //开启事务注解驱动器
public class Spring6Config {
    //Spring框架，看到这个@Bean注解后，会调用这个被标注的方法，这方法的返回值是一个java对象，这个java对象会自动注入IoC容器管理
    //返回的对象就是Spring容器当中的一个Bean
    //并且这个Bean的名字是dataSource
    @Bean(name = "dataSource")
    public DruidDataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring6");
        dataSource.setUsername("root");
        dataSource.setPassword("mp102030..");
        return dataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){ //spring在调用这个方法的时候会自动给我们传递过来一个dataSource对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean(name = "txManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource);
        return txManager;
    }
}
