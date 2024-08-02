package com.baimiaomiao.bank.service.impl;

import com.baimiaomiao.bank.dao.AccountDao;
import com.baimiaomiao.bank.dao.impl.AccountDaoImpl;
import com.baimiaomiao.bank.exceptions.MoneyNotEoughException;
import com.baimiaomiao.bank.exceptions.TransferException;
import com.baimiaomiao.bank.pojo.Account;
import com.baimiaomiao.bank.service.AccountService;
import com.baimiaomiao.bank.utils.GenerateDaoProxy;
import com.baimiaomiao.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {

    //private AccountDao accountDao = new AccountDaoImpl();


    //自己封装的代理生成类：直接利用动态生成类生成AccountDao接口的实现类
    //private AccountDao accountDao = (AccountDao) GenerateDaoProxy.generate(SqlSessionUtil.openSession(), AccountDao.class);

    //在mybatis中也提供了相关的机制，可以动态的为我们生成dao接口的实现类（代理类：dao接口的代理）
    //mybatis当中实际上采用了代理模式，在内存中生成dao接口的代理类，然后创建代理类的实例
    //注意：使用mybatis的这种代理机制的前提：SqlMapper.xml文件中namespace必须是dao接口的全限定名称，id必须是dao接口的方法名
    private AccountDao accountDao = SqlSessionUtil.openSession().getMapper(AccountDao.class);


    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEoughException, TransferException {

        //添加事务控制代码
        SqlSession sqlSession = SqlSessionUtil.openSession();

        //1.判断转出账户的余额是否充足（select）
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            //2.如果转出账户余额不足，提示用户
            throw new MoneyNotEoughException("对不起，余额不足！");
        }
        //3.如果转出账户余额充足，更新转出账户余额（update）
        //先更新内存中java对象的account的余额
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountDao.updateByActno(fromAct);


        //4.更新转入账户余额（update）
        count += accountDao.updateByActno(toAct);
        if (count != 2) {
            throw new TransferException("转账异常，未知原因");
        }

        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
}
