package cn.baimiaomiao.dao.impl;

import cn.baimiaomiao.dao.StudentDao;
import org.springframework.stereotype.Repository;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className StudentDaoImplForMySQL
 * @since 1.0
 */

@Repository("studentDao")
public class StudentDaoImplForMySQL implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL数据库正在删除学生信息......");
    }
}
