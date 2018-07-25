package com.iotimc.util;

import com.iotimc.config.RocketmqProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * MQ工具
 */
@Component
@Slf4j
public class MQUtil {
    @Autowired
    @Qualifier("defaultProducer")
    private DefaultMQProducer producer;
    @Autowired
    private RocketmqProperties properties;

    public void send(MQBody body) throws Exception {
        if(!properties.getEnable()) {
            log.warn("MQ: 尝试请求发送MQ消息失败，系统未启用MQ服务。");
            return;
        }
        Message message = new Message(body.getTopic(), body.toString().getBytes());
        try {
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.debug("MQ: 消息发送成功：{}",sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    log.error("MQ: 消息发送失败：{}", throwable.getMessage());
                }
            });
        } catch(Exception e) {
            log.error("MQ: 消息发送失败{}", e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
