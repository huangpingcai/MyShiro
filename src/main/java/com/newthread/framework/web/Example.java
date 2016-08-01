package com.newthread.framework.web;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by huangpingcaigege on 2016/5/30.
 */
@Controller
public class Example {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){

        Logger logger = Logger.getLogger(this.getClass());
        logger.setLevel(Level.INFO);

        logger.info("Controller ------> Example");

        return null;
    }





}
