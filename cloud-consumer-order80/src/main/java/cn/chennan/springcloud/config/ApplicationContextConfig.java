package cn.chennan.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author cn
 * @date 2020-05-28 10:51
 */
@Configuration
public class ApplicationContextConfig {
    // application.xml <bean id="" class=""/>
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
