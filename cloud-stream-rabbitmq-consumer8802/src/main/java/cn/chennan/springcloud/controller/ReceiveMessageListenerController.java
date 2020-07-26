package cn.chennan.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author cn
 * @date 2020-07-26 16:10
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverProt;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println(String.format("消费者1号, ---> 接收到的消息: %s, 端口号: %s", message.getPayload(), serverProt));
    }

}
