package cn.chennan.springcloud.service.impl;

import cn.chennan.springcloud.dao.PaymentDao;
import cn.chennan.springcloud.entities.Payment;
import cn.chennan.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cn
 * @date 2020-05-27 17:57
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id")Long id){
        return paymentDao.getPaymentById(id);
    }
}
