package com.iotimc.util;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.sql.Timestamp;

public class MQBody implements Serializable{
    private String imei;
    private String attr;
    private Object value;
    private String callback;
    private String method;
    private Timestamp sendtime;
    private String topic;

    public MQBody() {

    }

    public MQBody(String imei, String attr, Object value, String method) {
        this(imei, attr, value, method, "onenet");
    }

    public MQBody(String imei, String attr, Object value, String method, String topic) {
        this.imei = imei;
        this.attr = attr;
        this.value = value;
        this.method = method;
        this.topic = topic;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Timestamp getSendtime() {
        return sendtime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendtime = sendtime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public static MQBody parse(String body) {
        return JSONObject.toJavaObject((JSONObject)JSONObject.parse(body), MQBody.class);
    }
}
