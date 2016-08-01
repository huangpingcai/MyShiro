package com.newthread.framework.service.impl;

import com.newthread.db.dao.user.UserRepository;
import com.newthread.db.entity.User;
import com.newthread.framework.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by huangpingcaigege on 2016/6/18.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserRepository userRepository;
    private final Logger logger = Logger.getLogger(UserServiceImpl.class);

    public User getUserByNamePassword(String userId, String password){

        User user = userRepository.getUserByNamePassword(userId,password);

        return user;
    }
}
