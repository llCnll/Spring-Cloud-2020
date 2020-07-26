package cn.chennan.springcloud.controller;

import cn.chennan.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cn
 * @date 2020-07-20 23:29
 */
@RestController
public class SendMessageController {
    @Autowired
    private IMessageProvider provider;

    @RequestMapping("/sendMessage")
    public String sendMessage() {
        return provider.send();
    }
}
