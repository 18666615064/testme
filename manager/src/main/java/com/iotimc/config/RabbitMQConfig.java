package com.iotimc.config;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RabbitMQProperties.class)
@ConditionalOnProperty(prefix = RabbitMQProperties.PREFIX, value = "host")
public class RabbitMQConfig {

    @Bean
    public Queue command() {
        return new Queue("command");
    }

    @Bean
    public Queue data() {
        return new Queue("data");
    }
}
