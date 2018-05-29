<%--
  Created by IntelliJ IDEA.
  User: SAMSUNG
  Date: 2018/5/29
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'login.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>

<body>
<form action="${pageContext.request.contextPath }/user/login2" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <!-- name属性是共后台取值用的 -->
            <td><input type="text" name="username"/></td>
        </tr>

        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="登录"/> </td>
            <span style="color:red;">${loginMsg}</span>
        </tr>
    </table>
</form>
</body>
</html>
