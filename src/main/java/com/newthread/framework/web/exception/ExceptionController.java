package com.newthread.framework.web.exception;

import com.newthread.framework.model.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:huangpingcaigege
 * Date:2016/7/31
 * Mail:11867939@qq.com
 */
@RestController
public class ExceptionController {

    @RequestMapping(value = "/hasNoRole.do",method = RequestMethod.GET)
    public ResponseMessage hasNoRole(){
        ResponseMessage message = new ResponseMessage();
        message.setMessage("对不起,你所在组没有这个角色,无法操作!");
        return message;
    }

    @RequestMapping(value = "/hasNoPermission.do",method = RequestMethod.GET)
    public ResponseMessage hasNoPermission(){
        ResponseMessage message = new ResponseMessage();
        message.setMessage("对不起,你没有权限,无法操作!");
        return message;
    }





}
