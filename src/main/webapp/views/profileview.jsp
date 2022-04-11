<%@ page import="app.entities.Client" %>
<%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль</title>
</head>
<body>
<jsp:include page="/views/include/header.jsp"/>

<div>
    <h3>Окно профиля</h3>
    <div>
        <label>Name: ${client.userName}</label>
        <br/>
        <label>Name: ${client.lastName}</label>
        <br/>
        <label>Name: ${client.nickName}</label>
        <br/>
        <label>Password: ${client.password}</label>
        <br/>
    </div>
    <div>
            <button onclick=location.href='/bank_app/profile/credit' >Кредиты</button>
            <button onclick=location.href='/bank_app/profileview'>Счета</button>
            <button onclick=location.href='/bank_app/profileview'>Страховки</button>
    </div>
</div>

<jsp:include page="/views/include/footer.jsp"/>
</body>
</html>
