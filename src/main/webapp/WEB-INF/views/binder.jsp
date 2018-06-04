<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8" %>

<!-- 引入spring的form标签库 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>数据绑定(转换器)</title>
	</head>
	<body>
	    <f:form commandName="binderCommand" action="${pageContext.request.contextPath }/binder/submit">
	         <%-- x轴坐标:<f:input path="point.x"/>
	         y轴坐标:<f:input path="point.y"/> <br/><br/> --%>
	         
	         <!-- 此时页面想显示 {x, y}  point对象转换成 "{10.0, 20.0}"-->
	                   坐标:<f:input path="point"/>     <br/>
	                   生日:<f:input path="birthday" /> <br/>
	                   
	         <f:button>提交</f:button>
	    </f:form>
	</body>
</html>