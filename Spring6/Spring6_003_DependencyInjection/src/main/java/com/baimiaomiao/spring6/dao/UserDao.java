package com.baimiaomiao.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean
 * @author baimiaomiao
 * @version 1.0
 * @className UserDao
 * @since 1.0
 */


public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class) ;

    public void insert(){
        logger.info("数据库正在保存用户信息......");
    }
}
