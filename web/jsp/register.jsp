<%--
  Created by IntelliJ IDEA.
  User: thobho
  Date: 3/19/19
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Register new user</h1>
    <div style="width: 100%">
        <div style="margin:20px auto; width: 400px; background-color: antiquewhite">
            <form action="registerAction" method="post">
                Login: <input name="login" type="text"><br>
                Password: <input name="password" type="password"><br>
                <input name="submit" type="submit">
            </form>
        </div>
    </div>
</body>
</html>
