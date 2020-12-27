package cn.chennan.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author cn
 * @date 2020-05-28 10:51
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    // 不加这个 访问/consumer/payment/nacos/1 会报错 java.net.UnknownHostException
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
