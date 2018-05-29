package com.ssm.controller;

import com.ssm.exception.StockDeficiencyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * Throwable
 *     Exception 异常
 *         Exception  编译期异常
 *         RuntimeException 运行期异常(避免)
 *     Error     错误(程序猿  一般不需要关心)
 *
 * 处理异常的2种方案
 *     方法名()后面 throws  IOException,FileNotFoundException         抛异常  throws
 *
 *     方法内:
 *     try... catch... finally...  捕获异常  try...catch
 *     throw new 新的自定义异常();
 *
 * 在SpringMVC框架中如何处理异常?
 */

 @Controller
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping("/test")
    public void test() throws Exception{
        System.out.println("ExceptionController中的test()..");
        //throw new 新的异常类();
        throw new StockDeficiencyException("库存不足！");
        //throw new IOException("文件读写异常");
    }
    //局部异常处理：@ExceptionHandler注解（要处理的异常类的.class）
    //加ExceptonHandler注解来标识此方法 是专门用来处理StockDeficiencyException
    //@ExceptionHandler默认处理的是java.lang.Exception
    //@ExceptionHandler(Exception.class)
    @ExceptionHandler(StockDeficiencyException.class)
    //@ExceptionHandler(IOException)
    public ModelAndView exceptionHandler(Exception e){
        System.out.println("ExceptionHandler类中的exceptionHandler()..");
        //第一个参数exception：表示视图名称
        //第二个参数：存储异常数据模型的key
        return new ModelAndView("exception","exception",e);
    }
}
