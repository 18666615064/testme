package com.iotimc.listener;

import com.alibaba.fastjson.JSONObject;
import com.iotimc.config.RocketmqEvent;
import com.iotimc.util.MQBody;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 处理向onenet发送的请求任务
 */
@Component
@Slf4j
public class MQListener {
    @Value("${config.onenet.retry}")
    private int retry;

    @EventListener(condition = "#event.msgs[0].topic=='onenet'")
    public void consumeMessage(RocketmqEvent event) {
        int idx = 0;
        List<MessageExt> msgs = event.getMsgs();
        try {
            for(; idx < msgs.size(); idx++) {
                MessageExt msg = msgs.get(idx);
                String messageBody = new String(msg.getBody(), RemotingHelper.DEFAULT_CHARSET);
                log.debug("MQ: 消息监听器接收到消息{} {} {}", msg.getMsgId(), msg.getTopic(), messageBody);
                MQBody body = null;
                try {
                    body = MQBody.parse(messageBody);
                    doSend(body, msg);
                } catch(Exception e) {
                    log.error("MQ: 处理消息: {} 失败,原因: {}", messageBody, e.getMessage());
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void doSend(MQBody body, MessageExt msg) {
        log.info("MQ: 收到消息[{}]", body);
    }
}

