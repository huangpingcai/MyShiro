package com.newthread.framework.web.user;

import com.newthread.framework.model.ResponseMessage;
import com.newthread.framework.model.user.LoginModel;
import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaServerTube;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by huangpingcaigege on 2016/6/18.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage login(@RequestBody LoginModel loginModel, HttpServletRequest request) throws UnsupportedEncodingException {

        String url = WebUtils.getRequestUri(request);

        logger.info(loginModel.getAccount() + "正在尝试登录");

        logger.error(url);

        UsernamePasswordToken token = new UsernamePasswordToken(loginModel.getAccount(),loginModel.getPassword());

        Subject subject = SecurityUtils.getSubject();
        ResponseMessage message = new ResponseMessage();
        String msg = null;

        try {
            subject.login(token);
            if(subject.isAuthenticated()){
                message.setCode("1");
                message.setMessage("登陆成功！");
            }else{
                message.setCode("0");
                message.setMessage("登陆失败！");
            }
        }catch (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            message.setMessage(msg);
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
            message.setMessage(msg);
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            message.setMessage(msg);
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            message.setMessage(msg);
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            message.setMessage(msg);
        } catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
            message.setMessage(msg);
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
            message.setMessage(msg);
        }

        logger.info(message.getMessage());

        return message;
    }

    @RequestMapping(value = "getUserInfo.do",method = RequestMethod.POST)
    public Object getUserInfo(){

        Subject subject = SecurityUtils.getSubject();

        ResponseMessage message = new ResponseMessage();

        logger.info("是否拥有权限:" + subject.isPermitted("write"));

        if(!subject.isAuthenticated()){
            message.setMessage("尚未登录!");
        }else{
            message.setMessage("已经登录!");
        }
        return message;
    }

    @RequiresRoles({"admin"})
    @RequestMapping(value = "hasRole.do",method = RequestMethod.POST)
    public ResponseMessage hasRole(){

        ResponseMessage message = new ResponseMessage();

        message.setMessage("拥有权限!");

        return message;
    }

    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    public ResponseMessage logout(){

        ResponseMessage message = new ResponseMessage();

        Subject subject = SecurityUtils.getSubject();

        if(!subject.isAuthenticated()){
            message.setMessage("汝尚未能录,不能退出!");
        }else{
            subject.logout();
            message.setMessage("退出成功!");
        }
        return message;
    }


    @RequestMapping(value = "closeSession.do",method = RequestMethod.POST)
    public ResponseMessage closeSession(HttpSession session){

        session.invalidate();
        ResponseMessage message = new ResponseMessage();
        message.setMessage("销毁成功!");
        return message;
    }

    @RequiresUser
    @RequestMapping(value = "rememberMe.do",method = RequestMethod.POST)
    public ResponseMessage requireGuest(){

        ResponseMessage message = new ResponseMessage();

        Subject subject = SecurityUtils.getSubject();

        if(subject.isAuthenticated()){
            message.setMessage("rememberMe!");
        }else{
            message.setMessage("游客,尚未登录!");
        }
        return message;
    }

}
