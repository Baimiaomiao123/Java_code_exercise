package com.baimiaomiao.springcloud.service;

import com.baimiaomiao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className PaymentService
 * @since 1.0
 */


public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);

}
