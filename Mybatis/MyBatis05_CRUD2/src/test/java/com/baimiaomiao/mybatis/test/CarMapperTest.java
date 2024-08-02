package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.CarMapper;
import com.baimiaomiao.mybatis.pojo.Car;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //面向接口，获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null,"8054","凯美瑞",3.0,"2000-01-10","新能源");
        int count = mapper.insert(car);
        System.out.println(count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //面向接口，获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(13L);
        System.out.println(count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(26L,"8054","凯美瑞",3.0,"2000-01-10","新能源");
        mapper.updateById(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(26L);
        System.out.println(car);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

}
