<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="app.entities.Client" %>

<%-- импорт библиотеки тегов JSTL позволяет добавить функционал на страницу jsp --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="clientAdm" class="app.entities.Client" scope="page"/>
<html>
<title>admin</title>
</head>
<body>

<table border="1" >
    <tr>
        <td>Name</td>
        <td>Last Name</td>
        <td>Nickname</td>
        <td>id</td>
        <td>password</td>
    </tr>
<c:forEach items="${clientMap}" var="clientsMap">

    <option ${clientAdm =clientsMap.value}>
        name: ${clientAdm.userName}
                <tr>
                    <td>${clientAdm.userName}</td>
                    <td>${clientAdm.lastName}</td>
                    <td>${clientAdm.nickName}</td>
                    <td>${clientAdm.id}</td>
                    <td>${clientAdm.password}</td>
                </tr>
            </c:forEach>
        </table>
    </option>
</table>


</body>
</html>
