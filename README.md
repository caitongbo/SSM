# ssm

SpringMvc学习笔记

1.
    http://localhost:8080/helloworld
    
        服务器忙，请稍后重试...

2.
    http://localhost:8080/helloworld?username=moming

        hello moming !!!

3.
    http://localhost:8080/user/showUserLogin

        登陆界面
4.
    http://localhost:8080/file/showUpload
    
        文件上传页面
        实现方法在jsp文件中
  
5.      
    http://localhost:8080/file/showDownload
    
        /**
             * 文件下载的方式一(了解实际开发中不会用):
             *
             * 在浏览器的操作中,凡是浏览器不认识的静态资源
             * 浏览器都会默认做下载操作
             * <a href="${pageContext.request.contextPath }/images/6.jpg">下载地址一</a>
             * 这种方式非常不安全
             */
        
            /**
             * 文件下载方式二(通用)
             * 以输出流的方式进行下载
             *
             */
             
            /**
             * 文件下载方式三(推荐): 使用SpringMVC提供的文件下载(只能在SpringMVC框架内用)
             */
6. 
    http://localhost:8080/form/show
        
        标签库演示
7.
    http://localhost:8080/ajax/show
    
            /**
             * 校验(注册用户)用户输入用户名时该用户是否存在
             * 如果存在 则给出提示信息
             * 如果不存在  则可以注册
             *
             * 现在我们希望返回一个字符串  "该用户太受欢迎"/"该用户名可用/请输入用户名！"  text
             *
             * 在ajax中响应数据可能会有中文乱码问题？ 解决途径:在@RequestMapping注解中加入 produces="text/html;charset=utf-8"
             *    采用@RequestMapping(value="/checkUsername",produces="text/html;charset=utf-8")
             */
8.
    http://localhost:8080/exception/test
        
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
 9.
    http://localhost:8080/path
    
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
         
             // http://localhost:8080/path/m1/
             // http://localhost:8080/path/m1/a
             // http://localhost:8080/path/m1/bbbbb
             @RequestMapping("/m1/*")
             
             // http://localhost:8080/path/m2/
             // http://localhost:8080/path/m2/a
             // http://localhost:8080/path/m2/a/b/c
             @RequestMapping("/m2/**")
             
             // http://localhost:8080/path/m3/a
             @RequestMapping("/m3/?")
             
             // 当方法中的形参的名字 和 {变量名} 不一致时要用@PathVariable(value="restful中的变量名")
             // http://localhost:8080/path/m4/admin
             @RequestMapping("/m4/{username}")
             
             // http://localhost:8080/path/m5/1/liming
             @RequestMapping("/m5/{id}/{name}")
             
             // 3种ant风格混用
             // http://localhost:8080/path/m6/a/kky/aaa/bbb/ccc/abc
             @RequestMapping("/m6/*/kk?/**/abc")
             
             // ant风格和restful风格混用
             // http://localhost:8080/path/m7/aaa/liyan
             @RequestMapping("/m7/*/{username}")
             
10.
    http://localhost:8080/log/*
             
             /add/
             /find/
             /modify/
             /remove/
             
             
 参考:
 
    https://blog.csdn.net/lxfHaHaHa/article/details/57078994?locationNum=5&fps=1