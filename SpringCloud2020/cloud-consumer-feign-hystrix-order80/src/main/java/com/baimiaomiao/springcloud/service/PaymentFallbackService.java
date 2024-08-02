package com.baimiaomiao.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className PaymentFallbackService
 * @since 1.0
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallbackService fall back - paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "------PaymentFallbackService fall back - paymentInfo_Timeout";
    }
}
