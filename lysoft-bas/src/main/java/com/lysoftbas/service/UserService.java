package com.lysoftbas.service;


import com.lysoftbas.entity.User;

import java.util.List;

public interface UserService {


    User findUser(User user);
    List<User> findAll();


}
