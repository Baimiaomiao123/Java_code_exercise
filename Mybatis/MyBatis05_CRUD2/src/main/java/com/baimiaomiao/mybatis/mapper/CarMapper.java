package com.baimiaomiao.mybatis.mapper; //mapper包就是dao包

import com.baimiaomiao.mybatis.pojo.Car;

import java.util.List;

//一般使用mybatis的话，一般不叫做XXXDao了，一般都是XXXMapper
public interface CarMapper {

    /**
     * 新增Car
     * @param car
     * @return
     */
    int insert(Car car);

    /**
     * 根据id删除Car
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 修改汽车信息
     * @param car
     * @return
     */
    int updateById(Car car);

    /**
     * 根据id查询汽车信息
     * @param id
     * @return
     */
    Car selectById(Long id);

    /**
     * 查询所有汽车的信息
     * @return
     */
    List<Car> selectAll();
}
