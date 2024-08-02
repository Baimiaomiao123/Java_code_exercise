package com.baimiaomiao.bank.dao.impl;

import com.baimiaomiao.bank.dao.AccountDao;
import com.baimiaomiao.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className AccountDaoImpl
 * @since 1.0
 */

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String actno) {
        String sql = "select actno,balance from t_act where actno = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);
    }

    @Override
    public int update(Account  act) {
        String sql = "update t_act set balance = ? where actno = ?";
        return jdbcTemplate.update(sql, act.getBalance(), act.getActno());
    }
    @Override
    public int insert(Account act) {
        String sql = "insert into t_act values(?,?)";
        return jdbcTemplate.update(sql,act.getActno(),act.getBalance());
    }
}
