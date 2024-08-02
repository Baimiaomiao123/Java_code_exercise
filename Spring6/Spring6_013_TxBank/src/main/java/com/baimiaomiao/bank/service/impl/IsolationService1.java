package com.baimiaomiao.bank.service.impl;

import com.baimiaomiao.bank.dao.AccountDao;
import com.baimiaomiao.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className IsolationService1
 * @since 1.0
 */

@Service("i1")
public class IsolationService1 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //负责查询
    //当前事务能够读取到别的事务没有提交的数据
    //@Transactional(isolation = Isolation.READ_UNCOMMITTED)
    //对方事务提交之后的数据我才能读到
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void getByActno(String actno){
        Account account = accountDao.selectByActno(actno);
        System.out.println("查询到的账户信息：" + account);
    }
}
