package com.iotimc.util;

import com.iotimc.dao.Lwm2MMappingRepository;
import com.iotimc.domain.Lwm2MMappingEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 存放临时值
 */
@Component
@Slf4j
public class InitUtil {
    @Autowired
    private Lwm2MMappingRepository lwm2MMappingRepository;
    private static Map<String, String> LmwMapping = new HashMap<>();
    @Value("${config.lwm2mmapping}")
    private String mappingtype;
    @PostConstruct
    public void init() {
        // 隔5分钟重新读取一次
        new Thread() {
            public void run() {
                while(true) {
                    refreshLmwMapping();
                    log.debug("刷新平台映射成功");
                    try {
                        Thread.sleep(300000);
                    } catch(Exception e) {}
                }
            }
        }.start();
    }

    /**
     * 读取平台映射
     */
    private void refreshLmwMapping() {
        LmwMapping.clear();
        List<Lwm2MMappingEntity> list = lwm2MMappingRepository.getList(mappingtype);
        for(Lwm2MMappingEntity item : list) {
            String dsid = item.getDsid();
            dsid = dsid.substring(0, dsid.indexOf('_')) + "_" + item.getInsid() + "_" + dsid.substring(dsid.indexOf('_') + 1, dsid.length());
            LmwMapping.put(dsid, item.getMapper());
            LmwMapping.put(item.getMapper(), dsid);
        }
    }

    /**
     * 获取平台映射
     * @return
     */
    public static Map<String, String> getLmwMapping() {
        return LmwMapping;
    }
}
