package com.newthread.db.dao.user;

import com.newthread.db.entity.User;

/**
 * Author:huangpingcaigege
 * Date:2016/7/30
 * Mail:11867939@qq.com
 */
public interface UserRepository {
    User getUserByNamePassword(String userId, String password);
}
