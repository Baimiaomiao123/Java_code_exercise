package com.baimiaomiao.bank.service;

import com.baimiaomiao.bank.pojo.Account;

import java.util.List;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className AccountService
 * @since 1.0
 */


public interface AccountService {

    /**
     * 开户
     * @param account
     * @return
     */
    int save(Account account);

    /**
     * 销户
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 修改账户信息
     * @param account
     * @return
     */
    int modify(Account account);

    /**
     * 根据账号名称查账户
     * @param actno
     * @return
     */
    Account getByActno(String actno);

    /**
     * 返回所有的账户信息
     * @return
     */
    List<Account> getAll();

    /**
     * 转账
     * @param fromActno 转出账户
     * @param toActno 转入账户
     * @param money 转账金额
     */
    void transfer(String fromActno,String toActno,double money);
}
