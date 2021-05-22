package com.lysoftbas.controller;

import com.auth0.jwt.interfaces.Claim;
import com.lysoftbas.util.token.JwtToken;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * lysoft
 * Creat by zmy on 2021-05-15 17:20
 */
@Controller
@RequestMapping("/verify")
public class VerifyController {

    @RequestMapping("/get/{name}")
    @ResponseBody
    public String getSesseion(HttpServletRequest request, @PathVariable("name") String name){
        HttpSession session = request.getSession();
        String value = (String)session.getAttribute(name);
        return "sessionId:"+session.getId()+" value:"+value;
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        String token = JwtToken.createToken();
        session.setAttribute("token",token);
        return token;
    }
    @RequestMapping("/verify")
    @ResponseBody
    public String verify(HttpServletRequest request){
        String authHeader = request.getHeader("token");
        //验证JWT的签名，返回CheckResult对象
        Map<String, Claim> result= JwtToken.verifyToken(authHeader);
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        if (result ==null){
            return "验证失败";
        }
        return "验证成功"+token;
    }
}
