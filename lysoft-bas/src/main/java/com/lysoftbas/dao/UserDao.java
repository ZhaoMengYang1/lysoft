package com.lysoftbas.dao;

import com.lysoftbas.entity.User;

import java.util.List;


public interface UserDao {

    User findUser(User user);
    List<User> findAll();

}
