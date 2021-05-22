package com.lysoftbas.controller;

import com.lysoftbas.entity.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * mvc和 postman传 list,Token,list+string 参数
 * lysoft
 * Creat by zmy on 2021-05-07 16:16
 */
@Controller
@RequestMapping("/thymeleaf")
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(22);
        userInfo.setEmail("654919432@qq.com");
        userInfo.setId(1);
        userInfo.setPassword("123");
        userInfo.setUserName("zhangsan");
        model.addAttribute("user",userInfo);
        return "index";
    }

    @RequestMapping("/listUser")
    @ResponseBody
    public String listUser(@RequestBody List<UserInfo> userInfoList){

        for (UserInfo userInfo: userInfoList){
            System.out.println("userInfo:"+userInfo);
        }
        return "OK,接收到消息";
    }

    @RequestMapping("/listUser2")
    @ResponseBody
    public String listUser2(@RequestParam("name") String name, @RequestBody List<UserInfo> userInfoList){

        System.out.println("name:"+name);
        for (UserInfo userInfo: userInfoList){
            System.out.println("userInfo:"+userInfo);
        }
        return "OK,接收到消息";
    }


    @RequestMapping("/listUser3")
    @ResponseBody
    public String listUser3(@RequestParam("name")String name, @RequestBody Map<String,Object> map){

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : "  + entry.getValue());
        }
        List<UserInfo> userInfoList = (List<UserInfo>) map.get("userInfoList");
        for (int i=0;i<userInfoList.size();i++){
            System.out.println("userInfo:"+userInfoList.get(i));
        }
        return "OK,接收到消息";
    }

    /**
     * 创建Cookie返回客户端
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/cookie")
    @ResponseBody
    public String cookieTest(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();//根据请求数据，找到cookie数组

        if (null==cookies) {//如果没有cookie数组
            System.out.println("没有cookie");
            Cookie cookie = new Cookie("name_test","value_test");//创建新cookie
            cookie.setMaxAge(5 * 60);// 设置存在时间为5分钟
            cookie.setPath("/");//设置作用域
            response.addCookie(cookie);//将cookie添加到response的cookie数组中返回给客户端
        } else {
            for(Cookie cookie : cookies){
                System.out.println("cookieName:"+cookie.getName()+",cookieValue:"+ cookie.getValue());
            }
        }


        return "cookie";
    }

    /**
     * 创建session
     * @return
     */
    @RequestMapping("/session")
    public String session(HttpServletRequest request){
        HttpSession session=request.getSession();//这就是session的创建
        session.setAttribute("username","TOM");//给session添加属性属性name： username,属性 value：TOM
        session.setAttribute("password","tommmm");//添加属性 name: password; value: tommmm
        System.out.println(session.getId());
        System.out.println("session.getAttribute:"+session.getAttribute("username"));
        return "cookie";
    }
    /**
     * 创建Token
     * @return
     */
    @RequestMapping("/token")
    public String token(HttpServletRequest request){
        HttpSession session=request.getSession();//这就是session的创建
        session.setAttribute("username","TOM");//给session添加属性属性name： username,属性 value：TOM
        session.setAttribute("password","tommmm");//添加属性 name: password; value: tommmm
        System.out.println(session.getId());
        System.out.println("session.getAttribute:"+session.getAttribute("username"));
        return "cookie";
    }

}
