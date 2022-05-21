<%--
  Created by IntelliJ IDEA.
  User: S Kotov
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">
<%if (session.getAttribute("creditCalck")!= null){%>
    <h4>Для вас подбран кредит</h4>
    <label> Название :</label> ${creditCalck.creditName} <br/>
    <label> Сумма :</label> ${creditCalck.amount}<br/>
    <label> Проценты :</label> ${creditCalck.ptc}<br/>
    <label> Срок :</label> ${creditCalck.creditTerm}<br/>
    <label> Платёж :</label> ${creditCalck.paymentMonth} <br/>
    <button name="confirm" type="submit">Подтвердить</button>
    <button name="cancel" type="submit">Отказаться</button>
    <%}else{ %>
    <h4>Для вас нет подходящих предложений</h4>
    <button name="cancel" type="submit">Отказаться</button>
    <% }%>

</form>


</body>
</html>
