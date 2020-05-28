package cn.chennan.springcloud.service;

import cn.chennan.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author cn
 * @date 2020-05-27 17:56
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
