package com.baimiaomiao.bank.service;

import com.baimiaomiao.bank.pojo.Account;

/**
 * 业务接口
 * 事务就是在这个接口下控制的
 * @author baimiaomiao
 * @version 1.0
 * @className AccountService
 * @since 1.0
 */


public interface AccountService {

    /**
     * 转账业务方法
     * @param fromActno 转出账户
     * @param toActno 转入账户
     * @param money 转账金额
     */
    void transfer(String fromActno,String toActno,double money);


}
