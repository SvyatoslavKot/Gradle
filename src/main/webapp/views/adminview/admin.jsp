<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="app.entities.Client" %>

<%-- импорт библиотеки тегов JSTL позволяет добавить функционал на страницу jsp --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<%@page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="clientAdm" class="app.entities.Client" scope="page"/>
<html>
<title>admin</title>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="utf-8">
</head>
<body>
<table border="1" >
    <h4>Таблица всех клиентов</h4>
    <tr>
        <td>Name</td>
        <td>Last Name</td>
        <td>Nickname</td>
        <td>id</td>
        <td>password</td>
    </tr>
    <%-- Реализация цикла forEach при помощи библиотеки тегов JSTL --%>
<c:forEach items="${clientMap}" var="clientsMap">
    <option ${clientAdm =clientsMap.value}>
                <tr>
                    <td>${clientAdm.userName}</td>
                    <td>${clientAdm.lastName}</td>
                    <td>${clientAdm.nickName}</td>
                    <td>${clientAdm.id}</td>
                    <td>${clientAdm.password}</td>
                </tr>
            </c:forEach>
        </table>


<table border="1" >
    <h4>Таблица всех кридитов</h4>
    <tr>
        <td>Название</td>
        <td>Номер счета</td>
        <td>Сумма</td>
        <td>Проценты</td>
        <td>Дата открытия</td>
        <td>Срок</td>
        <td>Платёж</td>
        <td>ID держателя</td>
    </tr>
    <c:forEach items="${creditList}" var="creditList">
        <tr>
            <td>${creditList.creditName}</td>
            <td>${creditList.accountNumber}</td>
            <td>${creditList.amount}</td>
            <td>${creditList.ptc}</td>
            <td>${creditList.openingDate}</td>
            <td>${creditList.creditTerm}</td>
            <td>${creditList.paymentMonth}</td>
            <td>${creditList.idHolder}</td>
            <td><a href=/bank_app/logining">ccskrf</a></td>

        </tr>
        </c:forEach>
</table>

<table border="1" >
    <h4>Таблица всех кридитов</h4>
    <tr>
        <td>Название</td>
        <td>Номер счета</td>
        <td>Баланс</td>
        <td>Срок обслуживания</td>
        <td>Годовое обслуживание</td>
        <td>CashBack</td>
        <td>ID держателя</td>
        <td>pin</td>
    </tr>

    <c:forEach items="${accountList}" var="account">
        <tr>
            <td>${account.nameAccount}</td>
            <td>${account.accountNumber}</td>
            <td>${account.moneyInAccount}</td>
            <td>${account.creditTerm}</td>
            <td>${account.payment}</td>
            <td>${account.cashBack}</td>
            <td>${account.idHolder}</td>
            <td>${account.pin}</td>
            <td><a href=/bank_app/logining">ccskrf</a></td>

        </tr>
    </c:forEach>
</table>
</option>
</table>

</body>
</html>
