<%@ page import="app.entities.Client" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%--
  Created by IntelliJ IDEA.
  User: Svyat
  Date: 001 01.04.22
  Time: 7:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<div>

    ${bank.name}
        <button onclick="location.href='/bank_app/main'">ГЛАВНАЯ</button>
        <button onclick="location.href='/bank_app/credit/main'">Кредиты</button>
        <button onclick="location.href='/bank_app/account/main'">Счёта</button>
        <button onclick="location.href='/bank_app/main/payment'">Платежи</button>
        <%
            Client client = (Client) session.getAttribute("client");%> <%--// присваем значения объекту из сесси по имени--%>

    <c:if test="${client.nickName != null}"><%--//если значение не null то формируем кнопку с логином и ссылкой на профиль--%>
        <button onclick=location.href='/bank_app/profileview'> ${client.nickName}</button>
    </c:if>

    <c:if test="${client.nickName == null}"> <%--//если значение не null то формируем кнопку войти--%>
        <button onclick=location.href='/bank_app/logining'>Войти </button>
    </c:if>



        <%
        response.setIntHeader("Refresh", 1);
        Calendar calendar = new GregorianCalendar();
        String am_pm;
        int hour= calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        if(calendar.get(Calendar.AM_PM)==0){
            am_pm = "AM";
        }else {
            am_pm = "PM";
        }
        String CT = hour + "h:" + minute + "m. " + am_pm;
        out.println("Текущее время: " + CT + "\n");
    %>
</div>

