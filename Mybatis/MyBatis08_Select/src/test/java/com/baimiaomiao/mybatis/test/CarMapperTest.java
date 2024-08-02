package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.CarMapper;
import com.baimiaomiao.mybatis.pojo.Car;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CarMapperTest {

    @Test
    public void testSelectTotal(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long count = mapper.selectTotal();
        System.out.println("总记录条数：" + count);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAllByMapUnderscoreToCamelCase(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByMapUnderscoreToCamelCase();
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAllByResultMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByResultMap();
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAllRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long,Map<String,Object>> carMaps = mapper.selectAllRetMap();
        System.out.println(carMaps);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAllRetListMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String,Object>> carListMaps = mapper.selectAllRetListMap();
        carListMaps.forEach(carMap -> System.out.println(carMap));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByIdRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String,Object> carMap = mapper.selectByIdRetMap(1L);
        System.out.println(carMap);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars =  mapper.selectById2(1L);
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByBrandLike(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //org.apache.ibatis.exceptions.TooManyResultsException
        //什么意思？你期望的结果是返回一条记录，但是实际的SQL语句在执行的时候，返回的记录是多条
        //Car car = mapper.selectByBrandLike("比亚迪");
        //System.out.println(car);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(1L);
        System.out.println(car);
        SqlSessionUtil.close(sqlSession);
    }
}
