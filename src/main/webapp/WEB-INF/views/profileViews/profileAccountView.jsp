<%--
  Created by IntelliJ IDEA.
  User: NADEZHDA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <td>Баланс</td>
        <td>Срок обслуживания</td>
        <td>Обслуживание счета</td>
        <td>CashBack</td>
        <td>Pin</td>
    </tr>
    <%-- Реализация цикла forEach при помощи библиотеки тегов JSTL --%>
    <c:forEach items="${accounts}" var="account_list">
        <tr>
            <td>${account_list.accountNumber}</td>
            <td><a href="/bank_app/main">${account_list.nameAccount}</a></td>
            <td>${account_list.moneyInAccount}</td>
            <td>${account_list.creditTerm}</td>
            <td>${account_list.payment}</td>
            <td>${account_list.cashBack}</td>
            <td>${account_list.pin}</td>
        </tr>
    </c:forEach>
</table>
<div>
    <form method="get">
        <label>Сортировать</label>
        <select name= "sortParam" title="сортировка"  resource="sss" >
            <option value="4">по дате</option>
            <option value="1">возрастанию баланса</option>
            <option value= "2">уменьшению баланса</option>
            <option value="3">по названию</option>
        </select>
        <button name="sortButton" type="submit">Cортировать</button>
    </form>
</div>
<jsp:include page="/views/include/footer.jsp"/>
</body>
</html>
