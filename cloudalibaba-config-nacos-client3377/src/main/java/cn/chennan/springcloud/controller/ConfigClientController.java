package cn.chennan.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cn
 * @date 2020-07-04 14:12
 */
@RestController
@RefreshScope // 支持nacos的动态刷新功能 通过SpringCloud原生注解实现配置自动刷新
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return serverPort +": " + configInfo;
    }
}
