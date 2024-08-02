package com.baimiaomiao.mybatis.test;


import com.baimiaomiao.mybatis.mapper.StudentMapper;
import com.baimiaomiao.mybatis.pojo.Student;
import com.baimiaomiao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代理模式：
 *      代理对象 链家
 *      代理方法 找房子
 *      目标对象 我
 *      目标方法 找房子
 */
public class StudentMapperTest {

    @Test
    public void selectByNameAndSex2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //mapper实际上指向了代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //mapper是代理对象
        //selectByNameAndSex是代理方法
        List<Student> students = mapper.selectByNameAndSex2("张三", '男');
        students.forEach(student -> System.out.println(student));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByNameAndSex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("张三", '男');
        students.forEach(student -> System.out.println(student));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testInsertStudentByPojo(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student(null,"李四",19,1.80,new Date(),'女');
        mapper.insertStudentByPojo(student);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testInsertStudentByMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("姓名","赵六");
        map.put("年龄",20);
        map.put("身高",1.81);
        map.put("生日",new Date());
        map.put("性别",'男');
        mapper.insertStudentByMap(map);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectBySex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Character sex = Character.valueOf('男');
        List<Student> students = mapper.selectBySex(sex);
        students.forEach(student -> System.out.println(student));
        SqlSessionUtil.close(sqlSession);
    }

    //java.util.Date,java.util.Date，他们都是简单类型
    @Test
    public void testSelectByBirth() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = sdf.parse("1980-10-11");
        List<Student> students = mapper.selectByBirth(birth);
        students.forEach(student -> System.out.println(student));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByName(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByName("李四");
        students.forEach(student -> System.out.println(student));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectById(2L);
        students.forEach(student -> System.out.println(student));
        SqlSessionUtil.close(sqlSession);
    }
}
