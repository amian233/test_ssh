<%--
  Created by IntelliJ IDEA.
  User: bazil
  Date: 2018/3/22
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
注册界面<br>
<form action="/test/main/register" method="post">
    姓名: <input name="name" type="text"> <br>
    性别: <input name="sex" type="radio" value="1">男 &nbsp;&nbsp; <input name="sex" type="radio" value="0">女
    <input type="submit" value="注册">
</form>
</body>
</html>