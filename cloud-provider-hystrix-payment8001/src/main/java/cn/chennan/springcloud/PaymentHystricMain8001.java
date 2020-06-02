package cn.chennan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cn
 * @date 2020-06-02 14:28
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystricMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystricMain8001.class, args);
    }
}
