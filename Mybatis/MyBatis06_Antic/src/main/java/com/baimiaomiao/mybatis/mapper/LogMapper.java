package com.baimiaomiao.mybatis.mapper;

import com.baimiaomiao.mybatis.pojo.Log;

import java.util.List;

public interface LogMapper {
    /**
     * 根据日期查询不同的表，获取表中不同的日志
     * @param date
     * @return
     */
    List<Log> selectAllByTable(String date);
}
