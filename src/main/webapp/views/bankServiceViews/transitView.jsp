<%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
    <jsp:include page="/views/include/header.jsp"/>
    <%if (session.getAttribute("client")== null){%>
        <p>Авторизуйтесь</p>
    <%}else{%>
    <%if (session.getAttribute("typeTransit").equals("ourSelf")) {%>
        <h4>Перевод средств между свомим счетами</h4>

    <form method="post">
    <label>Счет списания</label><br/>
    <select name="account_1">
    <c:forEach items="${accounts}" var="account">
        <option value="${account}">${account.accountNumber}</option>
    </c:forEach>
    </select>
    <label>Счет зачисления</label><br/>
    <select name="account_2">
        <c:forEach items="${accounts}" var="account">
            <option value="${account}">${account.accountNumber}</option>
        </c:forEach>
    </select>
    <label>Cумма перевода:
    <input type="text" name="sum">
    </label>
    <button name="send" type="submit">Перевести</button>
    </form>

    <%}else if  (session.getAttribute("typeTransit").equals("clientBank")){%>
    <p>clientBank</p>
    <%}else if  (session.getAttribute("typeTransit").equals("clientOtherBank")){%>
    <p>clientOtherBank</p> <%} }%>


    <jsp:include page="/views/include/footer.jsp"/>
    </body>
</html>
