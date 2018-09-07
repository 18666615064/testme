package com.iotimc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(RabbitMQProperties.PREFIX)
public class RabbitMQProperties {
    public static final String PREFIX = "spring.rabbitmq";
    private Boolean enable;
    private String host;
    private Integer port;
    private String username;
    private String password;
    private String publisherConfirm;
    private String virtualHost;
    private String defaultTopic;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPublisherConfirm() {
        return publisherConfirm;
    }

    public void setPublisherConfirm(String publisherConfirm) {
        this.publisherConfirm = publisherConfirm;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

    public String getDefaultTopic() {
        return defaultTopic;
    }

    public void setDefaultTopic(String defaultTopic) {
        this.defaultTopic = defaultTopic;
    }
}
