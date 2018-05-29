package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by caitongbo.
 * Date: 2018/5/29
 * Time: 17:01
 */
@Controller
@RequestMapping("/log")
public class LogController
{
    // http://localhost:8080/SpringMVC/log/add
    @RequestMapping("/add")
    public void add()
    {
        System.out.println("LogController类中的   add()..... ");
    }

    // http://localhost:8080/SpringMVC/log/find
    @RequestMapping("/find")
    public void find()
    {
        System.out.println("LogController类中的   find()..... ");
    }

    // http://localhost:8080/SpringMVC/log/modify
    @RequestMapping("/modify")
    public void modify()
    {
        System.out.println("LogController类中的   modify()..... ");
    }

    // http://localhost:8080/SpringMVC/log/remove
    @RequestMapping("/remove")
    public void remove()
    {
        System.out.println("LogController类中的   remove()..... ");
    }
}