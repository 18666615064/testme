package com.iotimc.listener;

import com.iotimc.util.MQBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 处理向onenet发送的请求任务
 */
@Component
@Slf4j
public class MQListener {
    @Value("${config.onenet.retry}")
    private int retry;

    @RabbitListener(queues = "command")
    @RabbitHandler
    public void consumeMessage(Message message) {
        try {
                String body = new String(message.getBody());
                log.debug("MQ: 消息监听器接收到消息[{}]",body);
                try {
                    doSend(MQBody.parse(body), message.getMessageProperties());
                } catch (Exception e) {
                    log.error("MQ: 处理消息: {}:{} 失败,原因: {}", message.getMessageProperties().getAppId(), body, e.getMessage());
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "data")
    @RabbitHandler
    public void handleString(String message) {
        log.debug("MQ: 接收到字符串消息[{}]", message);
    }

    public void doSend(MQBody body, MessageProperties message) {

    }
}

