package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.CarMapper;
import com.baimiaomiao.mybatis.pojo.Car;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className CarMapperTest
 * @since 1.0
 */


public class CarMapperTest {

    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null,"6666","丰田霸道",32.0,"2015-05-12","新能源");
        int count =  mapper.insert(car);
        System.out.println("插入条数：" + count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(40L);
        System.out.println("删除条数：" + count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(41L,"6666","丰田霸道",32.0,"2015-05-12","新能源");
        int count =  mapper.update(car);
        System.out.println("更新条数：" + count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(41L);
        System.out.println(car);
        SqlSessionUtil.close(sqlSession);
    }
}
