package com.baimiaomiao.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws IOException {
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory对象
        //默认从resource根路径下查找文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();//如果使用的是JDBC的话，底层实际上会执行：conn.setAutoCommit();

        //执行sql语句
        int count = sqlSession.insert("insertCar"); //返回值是影响数据库表当中的记录条数
        System.out.println("插入了几个条数：" + count);

        //手动提交
        sqlSession.commit(); //如果使用的是JDBC，底层实际上还是或执行conn.commit()
    }
}
