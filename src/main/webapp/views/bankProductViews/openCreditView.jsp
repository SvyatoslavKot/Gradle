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
    <br />
    <label>Тип:<br />
        <select name="type" >
            <option value="CREDITCARD">Кредитная</option>
            <option value="CONSUMER">Потребительский</option>
            <option value="AVTO">Автокредит</option>
            <option value="HYPOTHEC">Ипотека</option>
        </select>
    </label><br />
    <br />
    <label>Срок кредита:<br />
        <select name="term" >
            <option value="3">3</option>
            <option value="6">6</option>
            <option value="12">12</option>
            <option value="18">18</option>
            <option value="24">24</option>
            <option value="36">36</option>
            <option value="60">60</option>
            <option value="120">120</option>
            <option value="240">240</option>
            <option value="360">360</option>
        </select>
    </label><br />
    <%--
кнопки type - submit отправляет пост запрос при нажатии на кнопку
прописал "name" по нему в методе "doPost" отлавливал нажатие кнопки
--%><br />
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
