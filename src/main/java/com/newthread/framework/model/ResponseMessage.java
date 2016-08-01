package com.newthread.framework.model;

/**
 * Created by huangpingcaigege on 2016/6/3.
 * 回复消息的实体
 */
public class ResponseMessage {

    private String code;
    private String message;
    private Object content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
