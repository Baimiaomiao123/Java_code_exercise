package com.baimiaomiao.ibatis.core;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC事务管理器（目前godbatis只对jdbc事务管理器进行实现）
 * @author baimiaomiao
 * @version 1.0
 * @since 1.0
 */
public class JdbcTransaction implements Transaction{

    /**
     * 数据源属性
     * 经典的设计：面向接口编程
     */
    private DataSource dataSource;

    /**
     * 自动提交标记
     * true表示自动提交，false表示不采用自动提交
     */
    private boolean autoCommit;

    private Connection connection;


    @Override
    //为保证同一个connection，需要对外提供一个getConnection方法
    public Connection getConnection() {
        return connection;
    }

    /**
     * 创建事务管理器对象
     * @param dataSource
     * @param autoCommit
     */
    public JdbcTransaction(DataSource dataSource, boolean autoCommit) {
        this.dataSource = dataSource;
        this.autoCommit = autoCommit;
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void openConnection(){
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                //开启事务
                connection.setAutoCommit(autoCommit);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
