package com.ssm.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 采用implements Controller 形式的handler
* */
public class HelloWorldController implements Controller {
    /*
    * ModelAndView 数据模型和视图
    * */
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
    String name =request.getParameter("username");
    ModelAndView modelAndView = new ModelAndView();

    //request.setAttribute("username",name);
    modelAndView.addObject("username",name); //设置数据模型
    modelAndView.setViewName("hello"); //设置视图名称

    return modelAndView;
    }
}
