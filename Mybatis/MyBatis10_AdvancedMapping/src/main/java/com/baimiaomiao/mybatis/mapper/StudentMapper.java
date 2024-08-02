package com.baimiaomiao.mybatis.mapper;

import com.baimiaomiao.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 根据班级编号查询学生信息
     * @param cid
     * @return
     */
    List<Student> selectByIdStep2(Integer cid);

    /**
     * 分步查询第一步：先根据学生的sid查询学生的信息
     * @param id
     * @return
     */
    Student selectByIdStep1(Integer id);

    /**
     * 一条SQL语句，association方式
     * @param id
     * @return
     */
    Student selectByIdAssociation(Integer id);

    /**
     * 根据id获取学生信息，同时关联的班级信息
     * @param id 学生的id
     * @return 学生对象，但是学生对象当中含有班级对象
     */
    Student selectById(Integer id);
}
