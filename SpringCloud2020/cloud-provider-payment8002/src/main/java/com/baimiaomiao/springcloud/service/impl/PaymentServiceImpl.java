package com.baimiaomiao.springcloud.service.impl;

import com.baimiaomiao.springcloud.dao.PaymentDao;
import com.baimiaomiao.springcloud.entities.Payment;
import com.baimiaomiao.springcloud.service.PaymentService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className PaymentServiceImpl
 * @since 1.0
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    }
}
