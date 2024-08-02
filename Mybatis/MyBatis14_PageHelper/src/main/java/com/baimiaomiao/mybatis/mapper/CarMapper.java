package com.baimiaomiao.mybatis.mapper;

import com.baimiaomiao.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className CarMapper
 * @since 1.0
 */


public interface CarMapper {

    /**
     * 查询所有的Car，通过分页查询插件PageHelper完成
     * @return
     */
    List<Car> selectAll();

    /**
     * 分页查询
     * @param startIndex 起始下标
     * @param pageSize 每页显示的记录条数
     * @return
     */
    List<Car> selectByPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

}
