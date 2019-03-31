<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        <%@include file="../css/login2.css" %>
    </style>
</head>
<body>

<%@include file="pageHeader.jsp" %>

<div>LOGOWANIE</div>

<div id="loginFormDiv">
    <form method="post" action="LoginAction2">
        <input name="login" type="text">
        <input name="password" type="password">
        <input name="submit" type="submit">
    </form>
</div>

<%@include file="pageFooter.jsp" %>

</body>
</html>
