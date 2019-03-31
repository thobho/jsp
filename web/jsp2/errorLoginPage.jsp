<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login errro</title>
    <style>
        <%@include file="../css/login2.css" %>
    </style>
</head>
<body>

<%@include file="pageHeader.jsp" %>

<%
    response.setStatus(401);
%>

<div style="font-size: 30px; color: red;">
    Nieporpawny login lub hasło.
</div>

<%@include file="pageFooter.jsp" %>

</body>
</html>