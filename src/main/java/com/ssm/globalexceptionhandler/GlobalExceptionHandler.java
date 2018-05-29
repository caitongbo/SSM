package com.ssm.globalexceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
* 全局异常系统类（整个SpringMvc系统都能用）
* 1.ControllerAdvice 用来标识此类是用来处理全局异常的
* 2.若要使用全局异常处理，须在SpringMvc的核心配置文件中有：<mvc:annotation-driven/>
* 3.在SpringMvc的核心配置文件中配置扫描包：<context:compoment-scan base-package"globalexceptionhandler"/>
* */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public String Exception(Exception e){
        System.out.println("GlaobalExceptionHandler类中的exceptionHandler()...");
        return  "error";
    }
}
