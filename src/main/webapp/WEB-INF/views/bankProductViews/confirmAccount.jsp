<%--
  Created by IntelliJ IDEA.
  User: NADEZHDA
  Date: 013 13.04.22
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Подтверждение</title>
</head>
<body>

<form method="post">
    <%if (session.getAttribute("accountCalk")!= null){%>
    <h4>Вам оформлен счет</h4>
    <label> Название :</label> ${accountCalk.nameAccount} <br/>
    <label> Номер счета :</label> ${accountCalk.accountNumber}<br/>
    <label> CashBack :</label> ${accountCalk.cashBack} <br/>
    <label> Срок действия :</label> ${accountCalk.creditTerm}<br/>
    <label> Плата за обслуживание :</label> ${accountCalk.payment}<br/>
    <label> Ваш pin :</label> ${accountCalk.pin}<br/>
    <button name="confirm" type="submit">Подтвердить</button>
    <button name="cancel" type="submit">Отказаться</button>
    <%}else{ %>
    <h4>Для вас нет подходящих предложений</h4>
    <button name="cancel" type="submit">Отказаться</button>
    <% }%>

</form>

</body>
</html>
