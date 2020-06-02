package cn.chennan.springcloud.service.impl;

import cn.chennan.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author cn
 * @date 2020-06-02 14:31
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return String.format("线程池: %s, paymentInfo_OK, id: %d", Thread.currentThread().getName(), id);
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("线程池: %s, paymentInfo_TimeOut, 耗时: %d", Thread.currentThread().getName(), id);
    }
}
