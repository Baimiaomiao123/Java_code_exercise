package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.CarMapper;
import com.baimiaomiao.mybatis.pojo.Car;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CarMapperTest {


    @Test
    public void testSelectByPrimaryKey(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car =  mapper.selectByPrimaryKey(1);
        System.out.println(car);
        SqlSessionUtil.close(sqlSession);
    }

}
