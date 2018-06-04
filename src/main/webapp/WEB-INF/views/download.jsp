<%--
  Created by IntelliJ IDEA.
  User: SAMSUNG
  Date: 2018/5/12
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utfs-8">
    <title>文件下载</title>
</head>
<body>
<h1>文件下载1</h1>
<a href="${pageContext.request.contextPath }/images/6.jpg">下载地址一</a>

<hr/>
<h1>文件下载2</h1>
<a href="${pageContext.request.contextPath }/file/download2">下载地址二</a>


<hr/>
<h1>文件下载3</h1>
<a href="${pageContext.request.contextPath }/file/download3">下载地址三</a>
</body>
</html>
