<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>ajax演示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

    <!-- js静态资源 -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>

    <script type="text/javascript">
        /*  
         $(function()
         {
         
         }); 
         */
         
         $(function()
         {
            $("#username").blur(function()
            {
                 // 使用jQuery发送ajax请求到后台
	             // $.ajax({});
	             $.ajax(
	             {
	                 type : 'post',  // 发送请求的方式是post请求  get delete put
	                 
	                 url  : '${pageContext.request.contextPath }/ajax/checkUsername',
	                 
	                 data : {'username' : $(this).val()},   // 用户输入的用户名
	                 
	                 dataType : 'text', // text 表示文本
	                 
	                 success : function(result)
	                 {
	                     // alert(result);
	                     
	                     $("#msg").html(result);   // 将后台返回结果的内容放入到 id="msg"的span标签中
	                 },
	                 
	                 error : function(data)
	                 {
	                     $("#msg").html(data); 
	                 }
	                 
	             });
            });
         });
        
    </script>
  </head>
  
  <body>
           用户名:<input type="text" id="username" name="username" /> <span id="msg"></span>
  </body>
</html>
