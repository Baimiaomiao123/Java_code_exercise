package com.baimiaomiao.bank.service;

import com.baimiaomiao.bank.exceptions.MoneyNotEoughException;
import com.baimiaomiao.bank.exceptions.TransferException;

/**
 * 注意：业务类中的业务方法在起名的时候最好见名知意
 * 账户业务类
 * @author baimiaaomiao
 * @version 1.0
 * @since 1.0
 */
public interface AccountService {

    /**
     * 账户转账业务
     * @param fromActno 转出账户
     * @param toActno 转入账户
     * @param money 转账金额
     */
    void transfer(String fromActno,String toActno,double money) throws MoneyNotEoughException, TransferException;

}
