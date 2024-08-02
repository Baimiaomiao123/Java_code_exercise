package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.CarMapper;
import com.baimiaomiao.mybatis.pojo.Car;
import com.baimiaomiao.mybatis.pojo.CarExample;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className CarMapperTest
 * @since 1.0
 */


public class CarMapperTest {

    //CarExample类负责封装查询条件的
    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //执行查询语句
        //查询一个
        Car car = mapper.selectByPrimaryKey(2);
        System.out.println(car);

        //查询所有
        List<Car> cars = mapper.selectByExample(null);
        cars.forEach(car1 -> System.out.println(car1));

        //按照条件查询
        /*QBC风格：Query By Criteria 一种查询方式，比较面向对象，看不到sql语句*/
        //通过CarExample对象封装查询条件
        CarExample carExample = new CarExample();
        //carExample.createCriteria()创建查询条件
        carExample.createCriteria()
                  .andBrandLike("比亚迪")
                  .andGuidePriceGreaterThan(new BigDecimal(5.0));
        //添加or
        carExample.or().andCarTypeEqualTo("新能源");
        List<Car> cars2 =  mapper.selectByExample(carExample);
        cars2.forEach(car2 -> System.out.println(car2));

        SqlSessionUtil.close(sqlSession);
    }
}
