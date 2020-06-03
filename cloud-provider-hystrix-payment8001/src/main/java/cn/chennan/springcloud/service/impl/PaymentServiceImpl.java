package cn.chennan.springcloud.service.impl;

import cn.chennan.springcloud.service.PaymentService;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        System.out.println(String.format("线程池: %s, paymentInfo_TimeOut, 耗时: %d", Thread.currentThread().getName(), id));
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("线程池: %s, paymentInfo_TimeOut, 耗时: %d", Thread.currentThread().getName(), id);
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return String.format("线程池: %s, paymentInfo_TimeOutHandler, id: %d", Thread.currentThread().getName(), id);
    }

    //============服务熔断========================
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启段路线
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return String.format("%s 调用成功, 流水号: %s", Thread.currentThread().getName(), serialNumber);
    }

    public  String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能是负数, 请稍后重试.." +id;
    }
}
