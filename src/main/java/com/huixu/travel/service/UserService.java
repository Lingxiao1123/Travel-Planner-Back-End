package com.huixu.travel.service;

import com.huixu.travel.dao.UserDao;
import com.huixu.travel.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void signUp(User user) {

        user.setEnabled(true);
        userDao.signUp(user);
    }

    public User getUser(String email) {
        return userDao.getUser(email);
    }
}
