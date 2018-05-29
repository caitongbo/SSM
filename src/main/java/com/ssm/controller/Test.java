package com.ssm.controller;

/**
 * Created by caitongbo.
 * Date: 2018/5/29
 * Time: 17:01
 */
public class Test
{
    public static void main(String[] args)
    {
        String fileName = "1.jpg";

        // "1.jpg"  ---> 1

        // substring(int beginIndex, int endIndex)  [beginIndex,endIndex)
        String substring = fileName.substring(0, fileName.lastIndexOf("."));
        System.out.println(substring);

        String str = "123";
        System.out.println(str.getClass());

    }
}