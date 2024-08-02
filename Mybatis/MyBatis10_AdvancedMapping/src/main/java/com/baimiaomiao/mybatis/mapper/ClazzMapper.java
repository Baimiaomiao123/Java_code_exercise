package com.baimiaomiao.mybatis.mapper;

import com.baimiaomiao.mybatis.pojo.Clazz;
import com.baimiaomiao.mybatis.pojo.Student;

import java.util.List;

public interface ClazzMapper {


    /**
     * 分步查询，第一步根据班级编号获取班级信息
     * @param cid
     * @return
     */
    Clazz selectByStep1(Integer cid);

    /**
     * 根据班级编号，查询班级信息
     * @param cid
     * @return
     */
    Clazz selectByCollection(Integer cid);

    /**
     * 分步查询第二步：根据cid获取班级信息
     * @param cid
     * @return
     */
    Clazz selectByIdStep2(Integer cid);

}
