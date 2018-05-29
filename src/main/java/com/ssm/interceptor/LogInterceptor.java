package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 1.拦截器的概念:
 * 用于handler业务处理之前  或者  之后 或者 响应到达之前  执行拦截handler业务处理方法
 *
 * 2.拦截器的使用
 * 1.创建一个Java类   implements  HandlerInterceptor接口
 * 实现此接口中的三个方法:
 * preHandle(用的最多)      : 在执行handler业务处理方法之前执行
 * postHandle              : 在执行handler业务处理方法之后执行
 * afterCompletion(很少用)  : 在执行handler业务处理之后,响应到达之前执行
 *
 * 2.在SpringMVC核心配置文件中  配置拦截器 <mvc:interceptors>
 * <!-- 需要拦截谁 -->
 * <mvc:mapping path="/log/*" />
 *
 * <!-- 不拦截谁  exclude 表示排除  -->
 * <mvc:exclude-mapping path="/log/find"/>
 *
 * <!-- 拦截器是谁 -->
 * <bean class="interceptor.LogInterceptor"></bean>
 *  *
 * Created by caitongbo.
 * Date: 2018/5/29
 * Time: 16:53
 */
public class LogInterceptor  implements HandlerInterceptor
{
    /**
     * 在执行handler业务处理方法之前执行
     * previous  --> pre
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        // request.getRemoteAddr()
        System.out.println(request.getRemoteAddr() + "访问了" + handler);

        // System.out.println("handler所在的运行时类:" + handler.getClass());

        // 如果返回值  为true 表示放行, 执行下一个组件(可能是下一个拦截器  也有可能是handler业务方法)
        // 如果返回值  为false 表示流程中断  胎死腹中(拦截器没有放行)
        return true;
    }

    /**
     * 在执行handler业务处理方法之后执行
     */
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception
    {
        System.out.println("handler业务方法处理结束.....");
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception
    {
        System.out.println("请求结束,响应即将到达.....");
    }


}
