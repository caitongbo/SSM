<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8" %>

<!-- 引入标签库: Spring form标签库 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring form标签库演示</title>
</head>
<body>
<!--
<form method="post" action="">
          用户名:<input type="text" name="liyan" value="liyan"/>
</form>
-->

<!-- html form表单的默认提交方式 method="get" 实际开发中99.9 是用post  method="post"-->
<f:form commandName="formCommand" action="${pageContext.request.contextPath }/form/submit">
    <!--
    java.lang.IllegalStateException:
    Neither BindingResult nor plain target object for
    bean name 'command' available as request attribute -->
    <!--
    path:属性即表示name属性,也表示value属性
    name属性: 表单提交数据的key   后台取值服务
    value属性: 设置此标签的默认值

    -->
    用户名:<f:input path="name" />  <br/>

    <!-- showPassword="true" 显示密码属性 -->
    密&nbsp;&nbsp;&nbsp;码:<f:password path="password" showPassword="true" /> <br/>

    <!-- 修改/删除用户信息用 -->
    <f:hidden path="id" />

    爱好:
    <!--
    <f:checkbox path="favor" value="1" label="吃饭" />
    <f:checkbox path="favor" value="2" label="打游戏" />
    <f:checkbox path="favor" value="3" label="敲代码" /> <br/>
    -->

    <!-- f:checkboxes：数据要求动态加载出来 -->
    <f:checkboxes items="${favorsMap }" path="favor"/> <br/>

    性别:
    <!--
    <f:radiobutton path="gender" value="1" label="男" />
    <f:radiobutton path="gender" value="2" label="女" /> <br/>
    -->

    <!-- f:radiobuttons：数据要求动态加载出来 -->
    <f:radiobuttons items="${userList }" path="gender" itemValue="id" itemLabel="username"/> <br/>

    月份:
    <f:select path="month">
        <!-- <f:option value="--请选择--"></f:option> -->
        <f:options items="${monthList }" />
    </f:select> <br/>

    <f:button>提交</f:button>
</f:form>
</body>
</html>