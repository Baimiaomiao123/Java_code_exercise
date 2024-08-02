package com.baimiaomiao.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class ConfigurationTest {
    @Test
    public void testDataSource() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //一个数据库一个，不要频繁创建
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));

        /*//会话1
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        sqlSession1.insert("baimiaomiao.insertCar");
        sqlSession1.commit();
        sqlSession1.close(); //因为要测试连接池的效果，关闭是需要的，要不然测不出来

        //会话2
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        sqlSession2.insert("baimiaomiao.insertCar");
        sqlSession2.commit();
        sqlSession2.close();*/
        SqlSession sqlSession = null;
        for (int i = 0; i < 4; i++) {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("baimiaomiao.insertCar");
            sqlSession.commit();
        }

        if (sqlSession != null) {
            sqlSession.close();
        }


    }

    @Test
    public void testEnvironment() throws IOException {
        //获取SqlSessionFactory对象（采用默认的的方式获取）
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //这里是用默认的环境（mybatis-config.xml文件中配置的为powernode数据库）
        SqlSessionFactory sqlSessionFactory1 = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory1.openSession();
        sqlSession1.insert("baimiaomiao.insertCar");
        sqlSession1.commit();
        sqlSession1.close();

        //这里用的是mybatisDB数据库
        SqlSessionFactory sqlSessionFactory2 = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "mybatisDB");
        SqlSession sqlSession2 = sqlSessionFactory2.openSession();
        sqlSession2.insert("baimiaomiao.insertCar");
        sqlSession2.commit();
        sqlSession2.close();

    }
}
