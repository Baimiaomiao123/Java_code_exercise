package cn.baimiaomiao.service;

import cn.baimiaomiao.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className StudentService
 * @since 1.0
 */

@Service("studentService")
public class StudentService {

    //只能放在属性和set方法上
    //@Resource(name="studentDaoImplForMySQL")
    @Resource //如果不写name=""，会默认根据该属性的名字去查找并注入
    private StudentDao studentDao;

    /*@Resource(name = "studentDaoImplForMySQL")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }*/

    public void deleteStudent(){
        studentDao.deleteById();
    }
}
