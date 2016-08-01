package com.newthread.framework.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by huangpingcaigege on 2016/5/8.
 */
public class ConfigReader {

    private static InputStream in = null;
    private static Properties prop = new Properties();

    /**
     * @param fileName 指定配置文件，传入null默认加载config.properties
     * @param key 键
     * @return 值
     */
    public static String getValue(String fileName,String key) {

        fileName = fileName == null ? "config.properties" : fileName;

        in = ConfigReader.class.getClassLoader().getResourceAsStream(fileName);

        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String value = prop.getProperty(key);
        return value;
    }

    /**
     * 获取配置值
     * @param key
     * @return
     */
    public static String getValue(String key){
        return getValue(null,key);
    }
}
