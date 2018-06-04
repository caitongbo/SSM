package com.ssm.interceptor;

import javax.servlet.http.*;
import com.ssm.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by caitongbo.
 * Date: 2018/6/4
 * Time: 9:09
 */
public class CheckLoginInterceptor implements HandlerInterceptor {
    /**
     * 在执行handler业务处理方法之前执行
     * previous  --> pre
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
            // 从session中获取用户信息
            User user = (User) httpServletRequest.getSession().getAttribute("user");

            // 判断用户的信息  如果用的信息没有user == null 代表用户没有登录 重定向到登录页面
            if (user == null) {
                // 重定向到登录页面
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/showUserLogin");
                return false; // 胎死腹中
            }

            // user != null 代表用户输入的用户名和密码正确  拦截器CheckLoginInterceptor 就放行
            return true;
        }
        /**
         * 在执行handler业务处理方法之后执行
         */
        @Override
        public void postHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object
        o, ModelAndView modelAndView) throws Exception {
            System.out.println("handler业务方法处理结束.....");
        }

        @Override
        public void afterCompletion (HttpServletRequest httpServletRequest, HttpServletResponse
        httpServletResponse, Object o, Exception e) throws Exception {
            System.out.println("请求结束,响应即将到达.....");
        }
    }
