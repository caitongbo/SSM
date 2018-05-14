package com.ssm.controller;

import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class AjaxController
{
    // http://localhost:8080/SpringMVC/ajax/show   ---> ajax.jsp
    @RequestMapping("/show")
    public String show()
    {
        return "ajax";
    }

    /**
     * 校验(注册用户)用户输入用户名时该用户是否存在
     * 如果存在 则给出提示信息
     * 如果不存在  则可以注册
     *
     * 现在我们希望返回一个字符串  "该用户太受欢迎"/"该用户名可用"  text
     *
     * 在ajax中响应数据可能会有中文乱码问题？ 解决途径:在@RequestMapping注解中加入 produces="text/html;charset=utf-8"
     *    采用@RequestMapping(value="/checkUsername",produces="text/html;charset=utf-8")
     */
    @ResponseBody
    @RequestMapping(value="/checkUsername",produces="text/html;charset=utf-8")
    public String checkUsername(String username)
    {
        System.out.println("111111111111111111111111");

        if ("admin".equals(username))
        {
            return "<font color='red'>该用户太受欢迎</font>";
        }else if (username.length()!=0)
        {
            return "<font color='green'>该用户名可用</font>";
        }
        else{
            return "请输入用户名！";
        }
    }
}