package com.newthread.framework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by huangpingcaigege on 2016/6/18.
 */
public class JsonUtils {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String Object2String(Object obj){

        String str = null;

        try {
            str = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Json转换失败");
        }


        return str;

    }


}
