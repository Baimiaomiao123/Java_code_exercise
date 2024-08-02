package com.baimiaomiao.ibatis.test;

import com.baimiaomiao.ibatis.core.SqlSession;
import com.baimiaomiao.ibatis.core.SqlSessionFactory;
import com.baimiaomiao.ibatis.core.SqlSessionFactoryBuilder;
import com.baimiaomiao.ibatis.pojo.User;
import com.baimiaomiao.ibatis.utils.Resources;
import org.junit.Test;

public class GodBatisTest {
    @Test
    public void testSelectOne(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourcesAsStream("godbatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行SQL语句
        Object obj = sqlSession.selectOne("baimiaomiao.selectById", "1111");
        System.out.println(obj);
        sqlSession.close();

    }

    @Test
    public void testSqlSessionFactory(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourcesAsStream("godbatis-config.xml"));
        System.out.println(sqlSessionFactory);
    }

    @Test
    public void testInsertUser(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourcesAsStream("godbatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行SQL insert
        User user = new User("1111","zhangsan","20");
        int count = sqlSession.insert("baimiaomiao.insertUser", user);
        System.out.println("执行条数：" + count);
        sqlSession.commit();
        sqlSession.close();
    }
}
