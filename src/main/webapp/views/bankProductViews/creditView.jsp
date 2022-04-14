<%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Credit View</title>
</head>
<body>
<jsp:include page="/views/include/header.jsp"/>
<form method="post">
    <h3>Кредиты</h3>
    <button name="openCredit", type="submit">Взять кредит</button>
</form>
<jsp:include page="/views/include/footer.jsp"/>
</body>
</html>
