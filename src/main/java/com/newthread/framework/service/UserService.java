package com.newthread.framework.service;

import com.newthread.db.entity.User;

/**
 * Created by huangpingcaigege on 2016/6/18.
 */
public interface UserService {
    User getUserByNamePassword(String userId, String password);
}
