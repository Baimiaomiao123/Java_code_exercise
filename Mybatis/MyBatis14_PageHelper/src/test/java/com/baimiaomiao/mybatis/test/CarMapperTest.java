package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.CarMapper;
import com.baimiaomiao.mybatis.pojo.Car;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className CarMapperTest
 * @since 1.0
 */


public class CarMapperTest {

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //在执行DQL语句前，开启分页功能
        int pageNum = 3;
        int pageSize = 3;
        PageHelper.startPage(pageNum,pageSize);

        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));

        //获取分页信息对象(PageInfo)
        //PageInfo对象是PageHelper插件提供的，用来封装分页相关信息的对象
        PageInfo<Car> pageInfo = new PageInfo<>(cars,5);
        System.out.println(pageInfo);

        SqlSessionUtil.close(sqlSession);
        /*
        PageInfo{pageNum=3, pageSize=3, size=3, startRow=7, endRow=9, total=34, pages=12,
        list=Page{count=true, pageNum=3, pageSize=3, startRow=6, endRow=9, total=34, pages=12, reasonable=false, pageSizeZero=false}
        [Car{id=8, carNum='1003', brand='丰田霸道', guidePrice=30.0, produceTime='2000-10-11', carType='燃油车'},
        Car{id=9, carNum='1003', brand='丰田霸道', guidePrice=30.0, produceTime='2000-10-11', carType='燃油车'},
        Car{id=10, carNum='1003', brand='丰田霸道', guidePrice=30.0, produceTime='2000-10-11', carType='燃油车'}],
        prePage=2, nextPage=4, isFirstPage=false, isLastPage=false, hasPreviousPage=true, hasNextPage=true, navigatePages=5, navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]}
        */
    }

    @Test
    public void testSelectByPage(){
        //获取每页显示的记录条数
        int pageSize = 3;
        //显示第几页：页码
        int pageNum = 1;
        //计算开始下标
        int startIndex = (pageNum - 1) * pageSize;

        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByPage(startIndex,pageSize);
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }
}
