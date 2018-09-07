package com.iotimc.util;

import com.iotimc.config.RabbitMQProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MQ工具
 */
@Component
@Slf4j
public class MQUtil {

    @Autowired
    private RabbitMQProperties properties;

    @Autowired
    private AmqpTemplate template;

    public void send(MQBody body) {
        if(!properties.getEnable()) {
            log.warn("MQ: 尝试请求发送MQ消息失败，系统未启用MQ服务。");
            return;
        }
        log.debug("发送MQ消息：[{}]", body.toString());
        template.convertAndSend(body.getTopic() == null?properties.getDefaultTopic():body.getTopic(), body.toString());
    }
}
