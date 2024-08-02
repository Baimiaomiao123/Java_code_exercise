package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.CarMapper;
import com.baimiaomiao.mybatis.pojo.Car;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class CarMapperTest {

    @Test
    public void testSelectById2() throws IOException {
        //这里只有一个sqlSessionFactory对象，二级缓存对应的就是sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);

        //这行代码结束之后，实际上是缓存到一级缓存当中，即sqlSession1对象中
        Car car1 = mapper1.selectById2(2L);
        System.out.println(car1);

        //如果这里不关闭sqlSession1对象的话，二级缓存还是没有数据的
        //如果执行了这行代码，sqlSession1的一级缓存中的数据会放到二级缓存当中
        SqlSessionUtil.close(sqlSession1);

        //这行代码结束之后，也会缓存到一级缓存当中，即sqlSession2对象中
        Car car2 = mapper2.selectById2(2L);
        System.out.println(car2);

        //程序执行到这里，会将sqlSession1这个一级缓存中的数据写入到二级缓存当中
        //SqlSessionUtil.close(sqlSession1);
        //程序执行到这里，会将sqlSession2这个一级缓存中的数据写入到二级缓存当中
        SqlSessionUtil.close(sqlSession2);


    }

    /*
        思考：什么时候不走缓存？sqlSession对象不是同一个；查询条件不一样
        思考：什么时候一级缓存失效？第一次DQL和第二次DQL之间做了以下两件事中的任意一件，都会让一级缓存清空
            1.执行了sqlSession.clearCache();即手动清空缓存
            2.执行了INSERT或DELETE或UPDATE语句，不管你是操作哪张表的，都会清空缓存
     */
    @Test
    public void testSelectById_again() throws IOException {
        //这里没有用工具类，获取的不是同一个sqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        //不是同一个sqlSession，会执行两次SQL语句
        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        Car car1 = mapper1.selectById(1L);
        System.out.println(car1);

        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);
        Car car2 = mapper2.selectById(1L);
        System.out.println(car2);

        sqlSession1.close();
        sqlSession2.close();
    }

    @Test
    public void testSelectById(){
        //这里使用了LocalThread，获取的都是同一个sqlSession
        SqlSession sqlSession = SqlSessionUtil.openSession();

        //同一个sqlSession，是一级缓存，此时只会执行一次SQL语句
        CarMapper mapper1 = sqlSession.getMapper(CarMapper.class);
        Car car1 = mapper1.selectById(1L);
        System.out.println(car1);

        //如果在这里执行一次手动清空缓存或INSERT/UPDATE/DELETE语句(为保证数据库数据与缓存区数据一致)，都会清空一级缓存
        //sqlSession.clearCache();

        //CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //int count =  mapper.insertClazz(1003,"高三三班");
        //System.out.println("已插入条数：" + count);

        CarMapper mapper2 = sqlSession.getMapper(CarMapper.class);
        Car car2 = mapper2.selectById(1L);
        System.out.println(car2);

        SqlSessionUtil.close(sqlSession);
    }
}
