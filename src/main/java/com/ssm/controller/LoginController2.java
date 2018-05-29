package com.ssm.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by caitongbo.
 * Date: 2018/5/29
 * Time: 17:03
 */
@Controller
@RequestMapping("/user")
public class LoginController2
{
    @RequestMapping("/showUserLogin")
    public String show()
    {
        return "login2";
    }

    // http://127.0.0.1:8080/SpringMVC/user/showUserLogin
    @RequestMapping("/login2")
    public ModelAndView login(String username, String password, HttpSession session)
    {
        ModelAndView  modelAndView = new ModelAndView();

        System.out.println(username + ":" + password);

        // java.sql
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            // ClassNotFoundException:
            // com.mysql.jdbc.Driver类全名写的不对
            // mysql-connector-java-5.1.24-bin.jar 没有  add build path
            Class.forName("com.mysql.jdbc.Driver");

            // tomcat的默认端口号8080
            // mysql数据库的默认端口号3306
            // Oracle数据库的默认端1521
            // MySQL数据不支持-, utf-8 ---> utf8
            String url = "jdbc:mysql:/127.0.0.1:3306/springmvc?useUnicode=true&characterEncoding=utf8";
            conn = DriverManager.getConnection(url, "root", "root");

            String  sql = new StringBuffer()
                    .append(" select ")
                    .append("     * ")
                    .append(" from t_user ")
                    .append(" where username = ? ")
                    .append(" and password = ? ")
                    .toString();

            ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next())
            {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("username"));  // 对应DB表中的字段 t_user
                System.out.println(rs.getString("password"));

                // 可以登录成功 ---> 用户名存在   success2.jsp
                modelAndView.setViewName("login2");
                modelAndView.addObject("userNm", username);

                return modelAndView;
            }

            // 登录失败  ---> 用户名或者密码错误
            modelAndView.setViewName("login2");
            modelAndView.addObject("loginMsg", "用户名或者密码错误");

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                // 关闭资源  rs  先使用的资源后关闭      后使用的资源先关闭
                if (rs != null)
                {
                    rs.close();
                }

                rs = null;  // 通知GC去回收此垃圾
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

            // ps

            // conn
        }

        return modelAndView;
    }
}