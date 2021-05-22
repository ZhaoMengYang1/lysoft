package com.lysoftbas.config;


import com.lysoftbas.controller.LoginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * lysoft
 * Creat by zmy on 2021-05-15 16:58
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginController loginController;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            throw new Exception("token不能为空");
        }
        Boolean verify = null;
        try {
            LoginController loginController=new LoginController();
//            verify = loginController.verify(token);
//            if(verify){
//                return true;
//            }else {
//                return false;
//            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
