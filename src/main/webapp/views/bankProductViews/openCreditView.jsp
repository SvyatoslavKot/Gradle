<%--
  Created by IntelliJ IDEA.
  User: NADEZHDA
  Date: 005 05.04.22
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/views/include/header.jsp"/>

<h2>Форма для рассчета кредита</h2>
<form method="post">
    <label>Сумма:<br />
        <input type="text" name="sum"><br />
    </label>
    <label>Срок кредита:<br />
        <input type="text" name="term"><br />
    </label>
    <label>Тип:<br />
        <input type="text" name="type"><br />
    </label>
    <%--
кнопки type - submit отправляет пост запрос при нажатии на кнопку
прописал "name" по нему в методе "doPost" отлавливал нажатие кнопки
--%>
    <button name="calck"  type="submit">Рассчитать</button>
    <button name="cancel" type="submit">Назад</button>
</form>
<p>
    <%
        if (request.getParameter("sum")!=null
                && request.getParameter("term")!= null && request.getParameter("type") !=null){
            if (request.getParameter("sum").isEmpty() ||request.getParameter("term").isEmpty()
                    ||request.getParameter("type").isEmpty()){
                out.print("Заполните все поле");
            }else if (session.getAttribute("client") == null){
                out.print("Авторизуйтесь");
            }
        }
    %>  </p>
<jsp:include page="/views/include/footer.jsp"/>
</body>
</html>
