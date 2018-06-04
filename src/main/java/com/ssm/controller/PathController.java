package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * http://localhost:8080/path
 *
 * ant风格的url
 *     *   星号表示单层目录
 *     **  2个星号  表示单层或者多层目录
 *     ?   单个字符的目录(不能没有)
 *
 * Restful风格的url(企业中现在用的多)
 *    {变量名}
 *
 *
 *
 */
@Controller
@RequestMapping("/path")
public class PathController
{
    // http://localhost:8080/path/m1/
    // http://localhost:8080/path/m1/a
    // http://localhost:8080/path/m1/bbbbb
    @RequestMapping("/m1/*")
    public void m1()
    {
        System.out.println("m1()......");
    }

    // http://localhost:8080/path/m2/
    // http://localhost:8080/path/m2/a
    // http://localhost:8080/path/m2/a/b/c
    @RequestMapping("/m2/**")
    public void m2()
    {
        System.out.println("m2()......");
    }

    // http://localhost:8080/path/m3/a
    @RequestMapping("/m3/?")
    public void m3()
    {
        System.out.println("m3()......");
    }

    // 当方法中的形参的名字 和 {变量名} 不一致时要用@PathVariable(value="restful中的变量名")
    // http://localhost:8080/path/m4/admin
    @RequestMapping("/m4/{username}")
    public void m4(@PathVariable String name)  //String username来源于URL的{username}位置
    {
        System.out.println("m4()......" + name);
    }

    // http://localhost:8080/path/m5/1/liyan
    @RequestMapping("/m5/{id}/{name}")
    public void m5(@PathVariable(value="id") String aa, @PathVariable(value="name") String bb)  //String username来源于URL的{username}位置
    {
        System.out.println("m5()...... id:" + aa + "  name:"+ bb);
    }

    // 3种ant风格混用
    // http://localhost:8080/path/m6/a/kky/aaa/bbb/ccc/abc
    @RequestMapping("/m6/*/kk?/**/abc")
    public void m6()
    {
        System.out.println("m6()......");
    }

    // ant风格和restful风格混用
    // http://localhost:8080/path/m7/aaa/liyan
    @RequestMapping("/m7/*/{username}")
    public void m7(@PathVariable String username)
    {
        System.out.println("m7()......" + username);
    }

}
