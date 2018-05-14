package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

/* 方法1
 * http://localhost:8080/showLogin
 * ModelAndView 返回数据模型与视图
 * */
/*    @RequestMapping("/showLogin")
    public ModelAndView showLogin(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("login"); //设置视图名称
        return modelAndView;
    }*/


/* 方法2
 * http://localhost:8080/showLogin
 *
 * String 返回视图
 * */
/*    @RequestMapping("/showLogin")
    public String showLogin(){
    return "login"; //跳转到具体界面 /WEB—INF/views/login.jsp
    }*/


/*方法3
 * http://localhost:8080/showLogin
 *  配置applicationContext.xml直接转发   <mvc:view-controller path="/showLogin" view-name="login" />
 *  或者全转发     <mvc:view-controller path="*"/>
 * */

//验证登陆信息
    @RequestMapping("/doLogin")
    public String login(String username,String password){
        if ("admin".equals(username)&& "admin".equals(password))
        {
            //登陆成功
            return "success"; //跳转到 /WEB—INF/views/success.jsp
        }
        //登陆失败
        return "redirect:/showLogin"; //重定向回showLogin界面
    }
}
