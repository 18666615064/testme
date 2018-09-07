package com.iotimc.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * 提供如时间格式转换，当前时间等小工具
 */
public class Tool {
    // 日期转换
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // 时间日期转换
    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 时间转换
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public static Timestamp getNowTiestamp() {
        return Timestamp.valueOf(getNowDateTimeStr());
    }

    public static Date getNowDate() {
        return new Date();
    }

    public static String getNowDateStr() {
        return dateFormat.format(getNowDate());
    }

    public static String getNowDateTimeStr() {
        return dateTimeFormat.format(getNowDate());
    }

    public static String getNowTimeStr() {
        return timeFormat.format(getNowDate());
    }

    public static Long getTimestampLong() {
        return getNowDate().getTime();
    }

    public static String joinHttpParam(Map o, String flag) {
        StringBuffer str_buff = new StringBuffer();
        Set<Map.Entry> set = o.entrySet();
        for (Map.Entry item : set) {
            str_buff.append(item.getKey());
            str_buff.append("=");
            str_buff.append(item.getValue());
            str_buff.append(flag);
        }
        return str_buff.toString().substring(0, str_buff.length() - 1);
    }
}
