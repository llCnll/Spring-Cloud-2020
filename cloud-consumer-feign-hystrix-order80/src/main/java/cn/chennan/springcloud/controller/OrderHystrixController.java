package cn.chennan.springcloud.controller;

import cn.chennan.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cn
 * @date 2020-06-02 16:27
 */
@RestController
@Slf4j
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result =  paymentHystrixService.paymentInfo_OK(id);
        log.info("****cn.chennan.springcloud.controller.OrderHystrixController#paymentInfo_OK result = {}", result);
        return "cn.chennan.springcloud.controller.OrderHystrixController#paymentInfo_OK "+result;
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result =  paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("****cn.chennan.springcloud.controller.OrderHystrixController#paymentInfo_TimeOut result = {}", result);
        return "cn.chennan.springcloud.controller.OrderHystrixController#paymentInfo_TimeOut "+result;
    }
}
