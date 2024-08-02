package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.ClazzMapper;
import com.baimiaomiao.mybatis.pojo.Clazz;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ClazzMapperTest {

    @Test
    public void testSelectByIdStep2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByStep1(1001);
        //只访问班级的名字
        System.out.println(clazz.getCname());
        System.out.println(clazz);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByCollection(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByCollection(1001);
        System.out.println(clazz);
        SqlSessionUtil.close(sqlSession);
    }

}
