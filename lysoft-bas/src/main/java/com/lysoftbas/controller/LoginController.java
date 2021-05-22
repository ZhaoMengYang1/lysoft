package com.lysoftbas.controller;

import com.auth0.jwt.JWT;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * lysoft
 * Creat by zmy on 2021-05-15 16:55
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 通过token获取用户
     * @param token
     */
    @GetMapping("/user/{token}")
    public void getUserName(@PathVariable("token") String token){
        String userName = JWT.decode(token).getClaim("userName").asString();
        System.out.println(userName);
    }



    @RequestMapping("/get/{name}")
    public String getSesseion(HttpServletRequest request, @PathVariable("name") String name){
        HttpSession session = request.getSession();
        String value = (String)session.getAttribute(name);
        return "sessionId:"+session.getId()+" value:"+value;
    }





}
