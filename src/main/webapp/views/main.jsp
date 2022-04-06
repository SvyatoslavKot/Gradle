<%@ page import="app.bankApp.Bank" %><%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главноая</title>
</head>

<jsp:include page="/views/include/header.jsp"/>

<body>
<div>
    <div>
        <h3>Главная страница</h3>
        <div>
            <label>Name: ${client.userName}</label>
            <br/>
            <label>Password: ${client.password}</label>

        </div>
    </div>
</div>
</body>
<jsp:include page="/views/include/footer.jsp"/>
</html>
