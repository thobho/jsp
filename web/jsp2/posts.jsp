<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Posts</title>
    <style>
        <%@include file="../css/login2.css" %>
    </style>
</head>
<body>

<%@include file="pageHeader.jsp" %>

    <form method="post" action="${pageContext.request.contextPath}/secret/AddPostAction">
        <textarea name="postText"></textarea>
        <input type="submit" name="submit">
    </form>




<%@include file="pageFooter.jsp" %>

</body>
</html>