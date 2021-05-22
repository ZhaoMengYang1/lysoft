package com.lysoftbas.service.impl;

import com.lysoftbas.dao.UserDao;
import com.lysoftbas.entity.User;
import com.lysoftbas.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

        @Override
    public User findUser(User user) {
        return userDao.findUser(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
