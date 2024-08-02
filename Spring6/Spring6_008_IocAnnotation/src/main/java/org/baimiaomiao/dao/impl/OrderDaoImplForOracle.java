package org.baimiaomiao.dao.impl;

import org.baimiaomiao.dao.OrderDao;
import org.springframework.stereotype.Repository;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderDaoImplForOracle
 * @since 1.0
 */

@Repository("orderDaoImplForOracle")
public class OrderDaoImplForOracle implements OrderDao {
    @Override
    public void insert() {
        System.out.println("Oracle数据库正在保存订单信息!");
    }
}
