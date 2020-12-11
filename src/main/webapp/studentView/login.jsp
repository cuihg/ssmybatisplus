<%--
  Created by IntelliJ IDEA.
  User: cuihg
  Date: 2020/11/12
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生登录</title>
</head>
<body>
    <form action="/queryAll" method="post">
        账号:<input type="text" name="account"><br>
        密码:<input type="text" name="password"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
