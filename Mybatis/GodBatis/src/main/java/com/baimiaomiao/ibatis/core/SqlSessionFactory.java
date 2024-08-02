package com.baimiaomiao.ibatis.core;

import java.util.Map;

/**
 * SqlSessionFactory对象：
 *      一个数据库对应一个SqlSessionFactory对象
 *      通过SqlSessionFactory对象可以获取SqlSession对象（开启会话）
 *      一个SqlSession对象可以开启多个SqlSession会话
 * @author baimiaomiao
 * @version 1.0
 * @since 1.0
 */
public class SqlSessionFactory {
    //思考SqlSessionFactory应该定义哪些属性？
    /**
     * 事务管理器属性
     * 事务管理器是可以灵活切换的（JDBC/MANAGED）
     * SqlSessionFactory类中的事务管理器应该是面向接口编程
     * SqlSessionFactory类中应该有一个接口
     */
    private Transaction transaction;

    //这里由于transaction里面需要数据源属性，所以这里的数据源属性就不需要了
    /**
     * 数据源属性
     */

    /**
     * 存放sql语句的map集合。
     * key是sqlId
     * value是对应的SQL标签信息对象
     */
    private Map<String,MappedStatement> mappedStatementMap;

    public SqlSessionFactory() {
    }

    public SqlSessionFactory(Transaction transaction, Map<String, MappedStatement> mappedStatementMap) {
        this.transaction = transaction;
        this.mappedStatementMap = mappedStatementMap;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }

    /**
     * 获取Sql会话对象
     * @return
     */
    public SqlSession openSession(){
        //开启会话的前提就是开启链接（连接打开）
        transaction.openConnection();
        //创建SqlSession对象
        SqlSession sqlSession = new SqlSession(this);
        return sqlSession;
    }
}
