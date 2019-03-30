<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.thobho.demoJsp.StaticWelcomeMessage" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.OptionalInt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="../css/exercises.css"%>
    </style>
</head>
<body>


<div id="header-div">
    <h1>
        Expression w JSP
    </h1>

    <p>
        <%= java.time.LocalDateTime.now() %>
    </p>

    <p>
        <%= 10 + 200 %>
    </p>
</div>

<p>
    <%= com.thobho.demoJsp.StaticWelcomeMessage.welcomeMessage("asd") %>
</p>


<h1 class="title-class">
    Skryptlet:
</h1>
<p>

        <% for (int i = 0; i < 2; i++) {%>

<h1><% out.print(i);%></h1>

<%}%>
</p>

<table style="border: 1px solid black">

    <thead>
    <tr>
        <td>Imie</td>
        <td>Nazwisko</td>
    </tr>
    </thead>

    <tbody>
    <tr>
        <td>Janusz</td>
        <td>Kowalski</td>
    </tr>
    <tr>
        <td>Janina</td>
        <td>Kwiatkowska</td>
    </tr>

    <%
        for (int i = 0; i < 3; i++) {
            out.print("<tr><td>" + i + "</td><td>" + i * i + "</td></tr>");
        }
    %>

    <%for (int i = 0; i < 3; i++) {%>
    <tr>
        <td><%= i%>
        </td>
        <td><% out.print(i); %></td>
    </tr>

    <%}%>

    </tbody>

</table>


<h1 class="title-class">
    Liczba wyświetleń:
</h1>

<%! private int visitCount = 0; %>

Liczba wyświetleń: <%=visitCount%>
<%
    visitCount++;
%>

<%
    //wyciągnięcie atrybutów z requestu
    String productName = request.getParameter("productName");
    String productCount = pageContext.getRequest().getParameter("productCount");
    if (productName == null || productCount == null) {
        out.print("Podaj parametry");
    } else {
        int productCountInt = Integer.parseInt(productCount);

        //wyciągniece mapy produktów z sesji
        Map<String, Integer> productsMap = (Map<String, Integer>) session.getAttribute("paroductsMap");

        //obsłużenie przypadku, gdy w sesji nie ma jeszcze mapy z prodktam
        if (productsMap == null) {
            HashMap<String, Integer> newProductsMap = new HashMap<>();
            newProductsMap.put(productName, productCountInt);
            session.setAttribute("paroductsMap", newProductsMap);


        } else {
            //ustawić ciasteczko w response

            Integer max = 0;

            for (Map.Entry<String, Integer> mapEntity : productsMap.entrySet()) {
                if (mapEntity.getValue() > max) {
                    max = mapEntity.getValue();
                }
            }

            response.addCookie(new Cookie("maxCountProduct", max.toString()));

            productsMap.put(productName, productCountInt);
            session.setAttribute("paroductsMap", productsMap);
        }
    }

%>

<%--<%--%>

<%--Map<String, Integer> produtMapToDisplay = (Map<String, Integer>) session.getAttribute("paroductsMap");--%>

<%--if (produtMapToDisplay == null) {--%>
<%--out.print("Nie ma żadnych produków  w liście.");--%>
<%--} else {--%>
<%--for (Map.Entry<String, Integer> mapEntity : produtMapToDisplay.entrySet()) {--%>
<%--out.print(mapEntity.getKey());--%>
<%--}--%>
<%--}--%>

<%--%>--%>

<table>
    <tbody style="border: 1px black solid">
    <%
        Map<String, Integer> produtMapToDisplay = (Map<String, Integer>) session.getAttribute("paroductsMap");
        if (produtMapToDisplay != null) {
            for (Map.Entry<String, Integer> mapEntity : produtMapToDisplay.entrySet()) {

    %>
    <tr>
        <td>
            <% out.print(mapEntity.getKey());%>
        </td>
        <td>
            <% out.print(mapEntity.getValue());%>
        </td>
    </tr>

    <%}%>
    <%}%>

    </tbody>
</table>


<div>
    Musisz kupić najwięcej ${cookie.get("maxCountProduct")}
</div>

<h1>
    Using beans:
</h1>


<jsp:useBean id="calculatorBean"
             class="com.thobho.demoJsp.MyCalculatorBean"
             scope="request"/>

<jsp:setProperty name="calculatorBean" property="multiplyNumber" value="10"/>
<jsp:setProperty name="calculatorBean" property="addingNumber" value="2"/>

<%
    int add = calculatorBean.add(100);
    int multiply = calculatorBean.multiply(100);

    out.print("<br>");
    out.print(add);
    out.print("<br>");
    out.print(multiply);

%>

<a href="http://google.pl">Google</a>
</body>