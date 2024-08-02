package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.LogMapper;
import com.baimiaomiao.mybatis.pojo.Log;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class LogMapperTest {
    @Test
    public void testSelectAllByTable(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        LogMapper mapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logs =  mapper.selectAllByTable("20230423");
        logs.forEach(log -> System.out.println(log));
        SqlSessionUtil.close(sqlSession);
    }
}
