<%@ page import="app.entities.Client" %><%--
  Created by IntelliJ IDEA.
  User: NADEZHDA
  Date: 001 01.04.22
  Time: 7:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    ${bank.name}

        <button onclick="location.href='/main'">Main view</button>
        <button onclick="location.href='/credit/main'">Кредиты</button>
        <button onclick="location.href='/profileview'">Счета</button>
    <%
        Client clientv = (Client) session.getAttribute("client");
        if( clientv!=null){
            if (clientv.getNickName()!=null){ %>
          <button onclick=location.href='/profileview'> ${client.nickName}  </button>
            <% }else { %>
                <button onclick=location.href='/logining'>Войти</button>
    <%}
     }else { %>
    <button onclick=location.href='/logining'>Войти</button>
    <%}%>
</div>

