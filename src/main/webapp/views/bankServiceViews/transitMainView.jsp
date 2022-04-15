<%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Платежи</title>
</head>
<body>
<jsp:include page="/views/include/header.jsp"/>
<div>
    <form method="post">
        <button  type="submit" name="ourSelf">Между своими счетами</button>
        <br/>
        <button type="submit" name="clientBank">Клиенту Банка</button>
        <br/>
        <button type="submit" name="clientOtherBank">Клиенту другого банка</button>
    </form>
</div>
<jsp:include page="/views/include/footer.jsp"/>
</body>
</html>
