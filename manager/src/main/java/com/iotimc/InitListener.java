package com.iotimc;

import com.iotimc.util.RedisUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitListener implements InitializingBean {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread() {
            @Override
            public void run() {
                redisUtil.put("test", "123");
                while(true) {
                    try {
                        System.out.println("Get");
                        redisUtil.get("test");
                        Thread.sleep(45000);
                    } catch(Exception e) {
                        try {
                            Thread.sleep(5000);
                        } catch (Exception ex) {}
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
