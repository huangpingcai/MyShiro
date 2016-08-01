package com.newthread.framework.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by huangpingcaigege on 2016/5/19.
 */
public class DateFormatUtils {

    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 将当前时间转换成String类型，用于更新用户表最后登录时间
     * @return
     */
    public static String Now2String(){
        Date date = Calendar.getInstance().getTime();
        return f.format(date);
    }
}
