package com.baimiaomiao.springcloud.dao;

import com.baimiaomiao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className PaymentDao
 * @since 1.0
 */

@Mapper
public interface PaymentDao {

    //增删改查...
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);

}
