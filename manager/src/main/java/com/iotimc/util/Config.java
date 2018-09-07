package com.iotimc.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix="config")
public class Config {
    private Map<String, String> onenet = new HashMap<String, String>();
    private Map<String, Object> easyiot = new HashMap<>();
    private String qrCodeKey = "";
    private String sockettype = "";

    public Map<String, String> getOnenet() {
        return onenet;
    }

    public void setOnenet(Map<String, String> onenet) {
        this.onenet = onenet;
    }

    public String getQrCodeKey() {
        return qrCodeKey;
    }

    public void setQrCodeKey(String qrCodeKey) {
        this.qrCodeKey = qrCodeKey;
    }

    public String getSockettype() {
        return sockettype;
    }

    public void setSockettype(String sockettype) {
        this.sockettype = sockettype;
    }

    public Map<String, Object> getEasyiot() {
        return easyiot;
    }

    public void setEasyiot(Map<String, Object> easyiot) {
        this.easyiot = easyiot;
    }
}
