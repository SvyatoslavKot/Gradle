<%--
  Created by IntelliJ IDEA.
  User: NADEZHDA
  Date: 013 13.04.22
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Платежи</title>
</head>
<body>
<jsp:include page="/views/include/header.jsp"/>
<div>
    <div>
        <h3>Раздел платежи</h3>
    </div>

        <button onclick="location.href='/bank_app/payment/taransit/main'">Перевести</button>
        <br/>
        <button onclick="location.href='/bank_app/main'">Оплатить</button>

</div>

<jsp:include page="/views/include/footer.jsp"/>
</body>
</html>
