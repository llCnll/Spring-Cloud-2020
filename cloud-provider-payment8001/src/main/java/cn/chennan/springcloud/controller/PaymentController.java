package cn.chennan.springcloud.controller;

import cn.chennan.springcloud.entities.CommonResult;
import cn.chennan.springcloud.entities.Payment;
import cn.chennan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author cn
 * @date 2020-05-27 18:02
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果: {}", result);

        if(result > 0){
            return new CommonResult(200, "插入数据库成功, server.port: "+serverPort, result);
        }else{
            return new CommonResult(444, "插入数据库失败, server.port: "+serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id")Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("****查询结果: {}", result);

        if(result != null){
            return new CommonResult(200, "查询成功, server.port: "+serverPort, result);
        }else{
            return new CommonResult(444, "没有对应记录, 查询ID"+id+", server.port: "+serverPort, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        services.forEach((service)->{
            log.info("****element: {}", service);
        });

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach((instance)->{
            log.info("{} {} {} {}", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        });

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        log.info("****cn.chennan.springcloud.controller.PaymentController#paymentFeignTimeout");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi, i'm payment zipkin server fall back";
    }
}
