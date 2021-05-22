package com.validation;

import com.auth0.jwt.interfaces.Claim;
import com.lysoftbas.entity.UserInfo;
import com.lysoftbas.service.UserInfoService;
import com.lysoftbas.util.token.JwtToken;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * lysoft
 * Creat by zmy on 2021-05-06 16:56
 */
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = {LysoftBasApplication.class})
public class UserInfoTest {
    @Autowired
    UserInfoService userInfoService;

    @Test
    public void validationTest(){
        userInfoService.insertUserInfo(initUserInfo());
    }

    public UserInfo initUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(1);
        userInfo.setEmail("654919432@qq.com");
//        userInfo.setId(2);
        userInfo.setUserName("zhangsan");

        return userInfo;
    }

    @Test
    public void tokenTest(){
        String token = JwtToken.createToken();
        System.out.println("token:"+token);
        Map<String, Claim> claims = JwtToken.verifyToken(token);
        System.out.println(claims.get("name").asString());
    }

    @Test
    public void pastDue(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmciOiLlpLTmnaEiLCJuYW1lIjoi5byg5LiJIiwiZXhwIjoxNjIxMjM1MTI4LCJpYXQiOjE2MjEyMzUwNjgsImFnZSI6IjI2In0.NRFrwmGIQK7dfoivW_WvpXEFgVhzq9DGc7ZMDu79zLw";
        Map<String, Claim> claims = JwtToken.verifyToken(token);
        System.out.println(claims.get("name").asString());
    }

}
