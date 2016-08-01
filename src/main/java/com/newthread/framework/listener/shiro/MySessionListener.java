package com.newthread.framework.listener.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * Author:huangpingcaigege
 * Date:2016/7/31
 * Mail:11867939@qq.com
 */
public class MySessionListener implements SessionListener {

    private final Logger logger = Logger.getLogger(SessionListener.class);

    @Override
    public void onStart(Session session) {
        logger.info("启动监听器!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    public void onStop(Session session) {

    }

    @Override
    public void onExpiration(Session session) {

    }
}
