<%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="creditUser" class="ru.bankApp.app.entities.creditFactory.Credit" scope="page"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/views/include/header.jsp"/>
<table border="1" >
    <h4>Список ваших кредитов</h4>
    <tr>
        <td>Номер счета</td>
        <td>Название</td>
        <td>Задолжность</td>
        <td>Проценты</td>
        <td>Дата Открытия</td>
        <td>Срок погашения</td>
        <td>Платёж</td>
        <td>Внести платех</td>
    </tr>
    <%-- Реализация цикла forEach при помощи библиотеки тегов JSTL --%>
    <c:forEach items="${credits}" var="credit_list">
        <tr>
            <td>${credit_list.accountNumber}</td>
            <td><a href="/bank_app/main">${credit_list.creditName}</a></td>
            <td>${credit_list.amount}</td>
            <td>${credit_list.ptc}</td>
            <td>${credit_list.openingDate}</td>
            <td>${credit_list.creditTerm}</td>
            <td>${credit_list.paymentMonth}</td>
            <td><input alt="center" type="submit" name="pay" value="pay"></td>
        </tr>
        </c:forEach>
</table>
<div>
    <form method="get">
        <label>Сортировать</label>
        <select name= "sortParam" title="сортировка"  resource="sss" >
            <option value="4">по дате</option>
            <option value="1">возрастанию задолжности</option>
            <option value= "2">уменьшению задолжности</option>
            <option value="3">по названию</option>
        </select>
        <button name="sortButton" type="submit">Cортировать</button>
    </form>
</div>
<jsp:include page="/views/include/footer.jsp"/>
</body>
</html>
