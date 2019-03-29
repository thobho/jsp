<%@ page import="com.thobho.demoJsp.StaticWelcomeMessage" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %>
<%--
  Created by IntelliJ IDEA.
  User: thobho
  Date: 3/29/19
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%--obiekty dostępne na stronie jsp--%>

<%
    out.print("Request: \n");
    out.print(request + "\n");

    out.print("Response" + "\n");
    out.print(response + "\n");

    out.print("Session" + "\n");
    out.print(session);

    out.print("Application" + "\n");
    out.print(application);

    out.print("PageContext" + "\n");
    out.print(pageContext + "\n");
%>

<%--wyrażenia--%>
<%--właściwie wyrażenie to sktór to out.print(..)--%>
<h1>
    Dzisiejsza data to:
    <%= java.time.Instant.now().toString() %>
</h1>

<h1>
    Proste dodawanie 10 + 20 =
    <%= 10 + 20%>
</h1>

<h1>
    Korzystanie ze statycznych metod, które stworzyliśmy:
    <%= StaticWelcomeMessage.welcomeMessage("Janusz")%>
</h1>


<%--skryptlety--%>
Aby kompilować JSP z java 8 trzeba wykonać następujące instrukcje:
<a href="https://stackoverflow.com/questions/40035001/lambda-expressions-in-jsp-files-will-not-compile">insrukcje</a>

<%
    List<String> strings = Arrays.asList("W ", "skryptlecie ", "można ", "wykonywać ", "kod ", "Javy");

    List<String> stringStream = strings.stream().map(String::toUpperCase).collect(Collectors.toList());

    out.print(strings);

    out.print(stringStream);

    for (int i = 0; i < 10; i++) {
        out.print(i);
    }
%>


<%--dyrektywy--%>
<%@include file="embedded.jsp" %>

<%@page
        session="true"
        autoFlush="false"
        pageEncoding="utf-8"
        info="Info o servlecie"
        language="java"
%>

<%
    BigDecimal bigDecimal = new BigDecimal(10);
    out.print("Dzięki importowi możemy korzystać z wszystkich klas javowych: (np. Big decimal) " + bigDecimal);
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>
    Za pomocą dyrektywy taglib używamy bibliotek tagów:
    <c:out value="JSTL działa"/>
</h1>


<%--deklaracje--%>
<h1>
    Za pomocą deklaracji wstawiamy do naszego servletu pole, które jest dostępne we wszystkich jego metodach:
</h1>
<%! int fieldVariable = 100; %>

<%
    fieldVariable++;
    out.print(fieldVariable);
%>


<%--język wyrażeń--%>

<p>
    Język wyrażeń pozwala nam wygodnie dostać się do zmiennych ${pageContext.request.getParameter("param")}
    W języku wyrażeń mamy dostęp do obiektów servletu JSP:
    ${applicationScope} <br/>
    ${cookie} <br/>
    ${headerValues} <br/>
    ${sessionScope} <br/>
    ${initParam} <br/>
</p>


<%--znaczniki akcji--%>

<jsp:include page="login.jsp"/>

<%
    if (false) {
%>
<jsp:forward page="register.jsp"/>
<%}%>

<h1>
    Beany to klasy javowe, do których mamy łatwy dostęp. W Java EE beany są często wykorzystywane.
</h1>

<jsp:useBean id="myBean" class="com.thobho.demoJsp.MyCalculatorBean" scope="request"/>
<jsp:setProperty name="myBean" property="addingNumber" value="155"/>
<jsp:setProperty name="myBean" property="multiplyNumber" value="99"/>

Sprawdzenie propery beana
<jsp:getProperty name="myBean" property="multiplyNumber"/>

Skorzystanie z beana
<%
    int add = myBean.add(100);
    out.print(add);
%>

</body>
</html>
