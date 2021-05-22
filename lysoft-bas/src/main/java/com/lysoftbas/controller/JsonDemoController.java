package com.lysoftbas.controller;

import com.alibaba.fastjson.JSONObject;
import com.lysoftbas.entity.User;
import com.lysoftbas.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: zmy
 * @date: 2021-05-19 17:46
 */
@Controller
@RequestMapping("/json")
public class JsonDemoController {
    @Autowired
    UserService userService;
    @RequestMapping("/jsonTest")
    @ResponseBody
    public JSONObject jsonTest(){
        JSONObject jsonObject = new JSONObject();

        List<User> userList =userService.findAll();
        jsonObject.put("userList",userList);

        return jsonObject;
    }




}
