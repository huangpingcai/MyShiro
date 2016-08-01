package com.newthread.db.dao.user.impl;

import com.newthread.db.dao.AbstractDao;
import com.newthread.db.dao.user.UserRepository;
import com.newthread.db.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Author:huangpingcaigege
 * Date:2016/7/30
 * Mail:11867939@qq.com
 */
@Repository
public class UserRepositoryImpl extends AbstractDao implements UserRepository {
    @Override
    public User getUserByNamePassword(String userId, String password) {

        Query query = getSession().createQuery("select u from User u where userId = :id and password = :p");

        query.setParameter("id",userId);
        query.setParameter("p",password);

        User user = (User) query.uniqueResult();

        return user;
    }
}
