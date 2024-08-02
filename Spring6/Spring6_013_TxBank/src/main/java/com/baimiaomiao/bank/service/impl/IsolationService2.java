package com.baimiaomiao.bank.service.impl;

import com.baimiaomiao.bank.dao.AccountDao;
import com.baimiaomiao.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className IsolationService2
 * @since 1.0
 */

@Service("i2")
public class IsolationService2 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //负责insert
    //@Transactional(timeout = 10,readOnly = true) //设置事务超时时间为10秒,以及启动spring的优化策略，提高select语句的执行效率
    //在当前事务中，最后一条DML语句执行之前，如果最后一条DML语句后面有业务逻辑，这些业务代码的执行时间不计入超时时间
    //@Transactional(rollbackFor = RuntimeException.class) //只要发生RuntimeException或者这个异常的子类异常，都回滚
    @Transactional(noRollbackFor = NullPointerException.class) //当异常是空指针异常的时候不回滚
    public void save(Account act) throws IOException {
        //睡眠一会
        /*try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        accountDao.insert(act);

        //模拟异常
        if(1 == 1){
            //throw new IOException();
            //throw new RuntimeException("出错了...");

            String s = null;
            s.toString();
        }

        //睡眠一会【以下的不会记为超时时间】
        /*try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //如果想整个事务都计时，只需要在最后面写一段无关紧要的DML语句即可
    }

}
