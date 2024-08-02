package com.baimiaomiao.bank.dao.impl;

import com.baimiaomiao.bank.dao.AccountDao;
import com.baimiaomiao.bank.pojo.Account;
import com.baimiaomiao.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = (Account) sqlSession.selectOne("com.baimiaomiao.bank.dao.AccountDao.selectByActno", actno);
        return account;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("com.baimiaomiao.bank.dao.AccountDao.updateByActno", act);
        return count;
    }
}
