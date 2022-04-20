<%@ page import="app.entities.Client" %>
<%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Профиль</title>
</head>
<body>

<%if (session.getAttribute("client")!= null  ) {%>
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
        <br/>
            <button onclick=location.href='/bank_app/profile/credit' >Кредиты</button><br/>
        <br/>
            <button onclick=location.href='/bank_app/profile/account'>Счета</button><br/>
        <br/>
            <button onclick=location.href='/bank_app/profileview'>Страховки</button><br/>
        <br/>
        <form method="post">
            <button name="exit" type="submit">Выйти</button>
        </form>
    </div>
</div>
<%}else if (session.getAttribute("client")== null){%>
<jsp:include page="/bank_app/logining"/>
<%}%>
<jsp:include page="/views/include/footer.jsp"/>
</body>
</html>
