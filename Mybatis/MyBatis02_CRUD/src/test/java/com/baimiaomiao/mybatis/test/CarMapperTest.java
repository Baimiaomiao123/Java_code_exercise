package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.pojo.Car;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {
    @Test
    public void testNameSpace(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //List<Car> cars = sqlSession.selectList("selectAllById");
        //争取完整的写法：namespace+id（namespace就是防止两个mapper的id冲突）
        List<Car> cars = sqlSession.selectList("heimiaomiao.selectAllById");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectAllById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //同样，这里也是需要加namespace
        List<Car> cars = sqlSession.selectList("baimiaomiao.selectAllById");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();

    }

    @Test
    public void testSelectOneById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //执行DQL语句
        Object car = sqlSession.selectOne("selectOneById",1);
        System.out.println(car);

        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        Car car = new Car(4L,"9999","凯美瑞",30.3,"2012-02-02","燃油车");

        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("updateById", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteById", 12);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPojo(){
        SqlSession sqlSession  = SqlSessionUtil.openSession();
        //封装数据
        Car car = new Car(null,"3333","比亚迪秦",30.0,"2022-02-02","燃油车");

        //执行SQL
        int count = sqlSession.insert("insertCar",car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();

        //这个对象先使用Map集合进行数据的封装
        Map<String,Object> map = new HashMap<>();
        map.put("k1","1111");
        map.put("k2","比亚迪汗");
        map.put("k3",10.00);
        map.put("k4","2020-11-11");
        map.put("k5","新能源");


        //执行SQL语句
        //insert方法的参数：
        //第一个参数：sqlId，从文件中复制
        //第二个参数：封装数据的对象
        int count = sqlSession.insert("insertCar",map);
        sqlSession.commit();
        sqlSession.close();
    }
}
