package cn.chennan.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author cn
 * @date 2020-06-02 18:21
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "cn.chennan.springcloud.service.PaymentFallbackService#paymentInfo_OK fallback";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "cn.chennan.springcloud.service.PaymentFallbackService#paymentInfo_TimeOut fallback";
    }
}
