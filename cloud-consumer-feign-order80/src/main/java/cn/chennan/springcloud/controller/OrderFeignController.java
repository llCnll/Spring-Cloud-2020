package cn.chennan.springcloud.controller;

import cn.chennan.springcloud.entities.CommonResult;
import cn.chennan.springcloud.entities.Payment;
import cn.chennan.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cn
 * @date 2020-06-01 16:10
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return paymentFeignService.create(payment);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id){
        return paymentFeignService.create(id);
    }

}
