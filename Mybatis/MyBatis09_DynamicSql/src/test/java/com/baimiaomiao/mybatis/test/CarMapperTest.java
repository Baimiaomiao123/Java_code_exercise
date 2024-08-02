package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.CarMapper;
import com.baimiaomiao.mybatis.pojo.Car;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarMapperTest {

    @Test
    public void testDeleteByIds2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {33L,34L};
        int count = mapper.deleteByIds2(ids);
        System.out.println("删除的记录条数：" + count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testInsertBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car1 = new Car(null,"5555","帕萨特",40.0,"2018-08-12","新能源");
        Car car2 = new Car(null,"5555","帕萨特",40.0,"2018-08-12","新能源");
        Car car3 = new Car(null,"5555","帕萨特",40.0,"2018-08-12","新能源");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        int count = mapper.insertBatch(cars);
        System.out.println("批量插入的条数为：" + count );
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDeleteByIds(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {30L,31L,32L};
        int count = mapper.deleteByIds(ids);
        System.out.println("删除的记录条数：" + count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByChoose(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //三个条件都不为空
        //List<Car> cars = mapper.selectByChoose("丰田霸道",30.0,"新能源");
        //第一个条件是空
        //List<Car> cars = mapper.selectByChoose(null,30.0,"新能源");
        //前两个条件都是空
        //List<Car> cars = mapper.selectByChoose(null,null,"新能源");
        //三个条件都是空
        List<Car> cars = mapper.selectByChoose(null,null,null);
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdateBySet(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(29L,null,"凯美瑞",null,null,"新能源");
        int count = mapper.updateBySet(car);
        System.out.println("更新的条数为：" + count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(29L,null,"丰田霸道",null,null,"新能源");
        int count = mapper.updateById(car);
        System.out.println("更新的条数为：" + count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByMultiConditionWithTrim(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiConditionWithTrim("比亚迪",null,"");
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByMultiConditionWithWhere(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //假设三个条件都不是空
        //List<Car> cars = mapper.selectByMultiConditionWithWhere("比亚迪",5.0,"燃油车");

        //假设三个条件都是空
        //List<Car> cars = mapper.selectByMultiConditionWithWhere("",null,"");

        //假设后两个条件不为空，第一个条件为空
        List<Car> cars = mapper.selectByMultiConditionWithWhere("",5.0,"燃油车");

        //假设第一个条件不是空，后两个条件是空
        //List<Car> cars = mapper.selectByMultiConditionWithWhere("比亚迪",null,"");

        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);

    }

    @Test
    public void testSelectByMultiCondition(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //假设三个条件都不是空
        //List<Car> cars = mapper.selectByMultiCondition("比亚迪",5.0,"燃油车");

        //假设三个条件都是空
        //List<Car> cars = mapper.selectByMultiCondition("",null,"");

        //假设后两个条件不为空，第一个条件为空
        //List<Car> cars = mapper.selectByMultiCondition("",5.0,"燃油车");

        //假设第一个条件不是空，后两个条件是空
        List<Car> cars = mapper.selectByMultiCondition("比亚迪",null,"");

        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }
}
