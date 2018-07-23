package com.iotimc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtil {
    @Autowired
    protected RedisTemplate<String, Object> redisTemplate;

    @Resource
    protected ValueOperations<String, String> valueOperations;

    public void put(String key, String domain) {
        valueOperations.set(getRedisKey(), domain);
    }

    public String get(String key) {
        return valueOperations.get(getRedisKey());
    }

    public String getRedisKey() {
        return "test";
    }
}
