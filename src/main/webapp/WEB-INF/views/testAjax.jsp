<%--
  Created by IntelliJ IDEA.
  User: SAMSUNG
  Date: 2018/5/21
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
    <%--不引入函数无法调用--%>

    <script type="text/javascript">
        $(function(){
            $("#username").blur(function () {
                $.ajax(
                    {
                        type:'post',
                        url:'${pageContext.request.contextPath}/ajax/checkUsername',
                        data:{'username':$(this).val()},
                        dataType:'text',

                        success :function (result) {
                            $("#msg").html(result);
                        },
                        error:function (data) {
                            $("#msg").html(data);
                        }
                    });
            });
        });
    </script>
</head>
<body>
    用户名<input type="text" id="username" name="username">
        <span id="msg"></span>
</body>
</html>
