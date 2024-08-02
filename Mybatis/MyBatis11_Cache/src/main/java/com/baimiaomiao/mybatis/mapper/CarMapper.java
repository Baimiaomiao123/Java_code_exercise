package com.baimiaomiao.mybatis.mapper;

import com.baimiaomiao.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

public interface CarMapper {

    /**
     * 测试二级缓存
     * @param id
     * @return
     */
    Car selectById2(Long id);

    /*
        以下插入应该在ClazzMapper中进行，为进行教学，故在这里写
     */
    int insertClazz(@Param("cid") Integer cid, @Param("cname") String cname);

    /**
     * 根据id获取汽车信息
     * @param id
     * @return
     */
    Car selectById(Long id);
}
