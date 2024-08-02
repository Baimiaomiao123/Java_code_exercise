package com.baimiaomiao.mybatis.test;

import com.baimiaomiao.mybatis.mapper.StudentMapper;
import com.baimiaomiao.mybatis.pojo.Student;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentMapperTest {

    @Test
    public void testSelectByIdStep1(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student =  mapper.selectByIdStep1(5);
        //System.out.println(student);

        //只需要看学生的名字
        System.out.println(student.getSname());
        //程序执行到这里，查看班级的名字
        System.out.println(student.getClazz().getCname());

        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByIdAssociation(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdAssociation(3);
        System.out.println(student);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1);

        /*System.out.println(student.getSid());
        System.out.println(student.getSname());
        System.out.println(student.getClazz().getCid());
        System.out.println(student.getClazz().getCname());*/
        System.out.println(student);

        SqlSessionUtil.close(sqlSession);
    }
}
