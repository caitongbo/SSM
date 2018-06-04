package com.ssm.controller;

import com.ssm.command.BinderCommand;
import com.ssm.entity.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.PropertyEditorSupport;

/**
 * Created by caitongbo.
 * Date: 2018/6/4
 * Time: 11:57
 */
@Controller
@RequestMapping("/binder")
public class BinderController
{
    // Date类型的 转换规则(不需要我们自己实现)在CustomDateEditor类中
    // public CustomDateEditor  dateEditor = new CustomDateEditor();

    // 属性装配 public CustomDateEditor  dateEditor = new CustomDateEditor();
    // 通过一个注解@Autowired
    @Autowired
    public CustomDateEditor dateEditor;


    // http://localhost:8080/SpringMVC/binder/show
    @RequestMapping("/show")
    public String show(BinderCommand binderCommand)
    {
        // 初始化数据

        // 初始化坐标数据
        Point point = new Point();
        point.setX(10.0d);
        point.setY(20.0d);

        binderCommand.setPoint(point);

        // "1986-08-21"  ---> java.sql.Date
        binderCommand.setBirthday(java.sql.Date.valueOf("1986-08-21"));


        return "binder";  // 跳转到WEB-INF/view/binder.jsp页面
    }

    @RequestMapping("/submit")
    public String submit(BinderCommand binderCommand)
    {
        Point point = binderCommand.getPoint();

        if (point != null)
        {
            System.out.println("x:" + point.getX()  + "  y:"+ point.getY());
        }


        System.out.println("birthday:" + binderCommand.getBirthday());

        return "redirect:show";  // 重定向到WEB-INF/view/binder.jsp页面
    }

    /**
     * 局部转换器
     *    1.在当前的Controller中定义一个方法(改方法的方法名任意 只要符合方法的命名规则即可)
     *      该方法的参数一般为WebDataBinder,
     *      通过@InitBinder注解标明该方法是一个局部数据绑定的方法
     *      在该方法中编写转换规则,并注册对应转换规则
     *
     *    2.编写转换规则
     *      使用PropertyEditorSupport类
     *         重写其中
     *           setAsText(): 将字符串转换成对象
     getAsText(): 将对象转换成字符串
     *
     *   3.注册转换规则
     */
    // 2.编写转换规则
    // 3.注册转换规则
    @InitBinder
    public void init(WebDataBinder webDataBinder)
    {
        System.out.println("BinderController.init()......");


        // 2.在该方法init中编写转换规则
        // 将Point对象  ---> 转换成 "{x, y}"
        PropertyEditorSupport pointEditor = new PropertyEditorSupport()
        {
            // 按快捷键 alt + shift + s ---> Override/implements Method

            /**
             * 将对象Point  转换成 字符串"{x,y}"
             */
            @Override
            public String getAsText()
            {
                // 要转换的对象Point
                // PropertyEditorSupport类提供的getValue()
                Point point = (Point)getValue();

                // 对要转换的对象做一个判断
                // 如果point == null 就return null
                // 如果point != null 就将对象Point  ---> 字符串"{x,y}"
                if (point == null)
                {
                    return null;
                }

                // return "{" + 坐标值 + "}";
                return "{" + point.getX() + "," + point.getY() + "}"; // "{x,y}"
            }

            /**
             * 将字符串转换成对象
             * 将 "{x,y}" --> Point对象
             */
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                if (text == null || "".equals(text))
                {
                    return;
                }

                // "{x,y}" --> Point对象
                Point point = new Point();
                // "{x,y}" ---> "x,y"  截取字符串

                // 从字符串中的第二个元素(下标1)开始截起 到 字符串中倒数第二个元素(下标 str.length - 1) 截止
                //  "{x,y} ---> "x,y"  截取字符串
                String str2 = text.substring(1,text.length() - 1);
                // 按照逗号分隔
                // 此时的splitArr中的第一个元素就是x轴坐标 第二个元素就是y轴坐标
                String[] splitArr = str2.split(",");
                // String x ---> Double x  Double  Double.parseDouble(x)
                // String  ---> Integer    Integer Integer.parseInt(str)
                String x = splitArr[0];
                String y = splitArr[1];


                point.setX(Double.parseDouble(x));
                point.setY(Double.parseDouble(y));

                //  PropertyEditorSupport类提供的setValue()
                setValue(point);

            }
        };


        // 3.注册转换规则
        // 通过 registerCustomEditor(class, editor)
        // 第一个参数: class 转换的对象Point所对应的class类型
        // 第二个参数: editor就是转换规则
        webDataBinder.registerCustomEditor(Point.class, pointEditor);

        /**
         * Date 生日  ---> String 生日
         */
        // 3.注册转换规则 --> 使用Spring提供的转换器
        // 第一种
        // webDataBinder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

        // 第二种 需要在SpringMVC 的核心配置文件中配置dateEditor 注入new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)
        webDataBinder.registerCustomEditor(java.util.Date.class, dateEditor);
    }
}
