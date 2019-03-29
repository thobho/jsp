<%--
  Created by IntelliJ IDEA.
  User: thobho
  Date: 3/19/19
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logn</title>
    <style><%@include file="../css/login.css"%></style>
</head>
<body>
<h1>You have account LOGIN!</h1>
<div id="login-form-container">
    <div id="login-form-div">
        <form action="loginAction" method="post">
            Login: <input id="login-input"  name="login" type="text"><br>
            Password: <input name="password" type="password"><br>
            <input name="submit" type="submit">
        </form>
    </div>
</div>
</body>
</html>
