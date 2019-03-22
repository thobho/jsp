<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: thobho
  Date: 3/20/19
  Time: 1:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JspElementsTutorial</title>
</head>
<body>
<%--scriptlet--%>
<%
    Date date = new Date();
    System.out.println(date.toString());
%>

<%--deklaracje--%>
<%! int a = 10; %>
<%! int b = 20; %>

<%
    int c = a + b;
    System.out.println(c);
%>

<%--wyrażenia--%>

Today's date: <%= (new java.util.Date()).toString()%>

<jsp:include page="part.jsp"/>
<jsp:useBean id="date2" type="java.util.Date" scope="session"/>

<%--implicit objects--%>

<%
    System.out.println(request);
    System.out.println(response);
    System.out.println(out);

%>

</body>
</html>
