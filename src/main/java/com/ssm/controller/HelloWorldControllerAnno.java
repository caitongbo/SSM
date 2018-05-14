package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
* 采用注解形式的handler
* */
@Controller
public class HelloWorldControllerAnno {
@RequestMapping("/helloworld")
/*
* ModelAndView 返回数据模型与视图
* */
    public ModelAndView sayHello(@RequestParam String username){
    ModelAndView modelAndView =new ModelAndView();
    modelAndView.addObject("username",username); //设置数据模型
    modelAndView.setViewName("hello"); //设置视图名称hello
    return modelAndView;


}
}
