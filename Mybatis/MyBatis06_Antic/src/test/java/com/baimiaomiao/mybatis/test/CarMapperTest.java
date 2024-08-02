package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.CarMapper;
import com.baimiaomiao.mybatis.pojo.Car;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {

    @Test
    public void testInsertCarUserGeneratedKeys(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null,"9999","凯美瑞",30.0,"2015-03-12","新能源");
        mapper.insertCarUserGeneratedKeys(car);
        System.out.println("赋值给id的值：" + car.getId());
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByBrandLike(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars =  mapper.selectByBrandLike("比亚迪");
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDeleteBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteBatch("23,24");
        System.out.println("删除数据条数：" + count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAllByAscOrDesc(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars =  mapper.selectAllByAscOrDesc("asc"); //或desc
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByCarType(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars =  mapper.selectByCarType("新能源");
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }
}
