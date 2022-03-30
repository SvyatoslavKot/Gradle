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

<div>
    <h3>окно профиля</h3>
    <div>
        <label>Name: ${client.userName}</label>
        <br/>
        <label>Password: ${client.password}</label>

    </div>
</div>


</body>
</html>
