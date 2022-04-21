<%@ page import="app.bankApp.FactoryProduct.accountFactory.TypeOfAccount" %><%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AccountView</title>
</head>
<body>

<br/>
<p><%
    if (request.getParameter("level")!=null
            && request.getParameter("term")!= null && request.getParameter("type") !=null) {
        if (session.getAttribute("client") == null) {
            out.print("Авторизуйтесь");
        } else if (request.getParameter("level").isEmpty()) {
            out.print("Выбирите уровень");
        } else if (request.getParameter("term").isEmpty()) {
            out.print("Выбирите уровень");
        } else if (request.getParameter("type").isEmpty()) {
            out.print("Заполните все поле");
        }
    }else{
        out.print("Заполните Форму");}
%>
</p>
<form method="post">
<label>Срок(мес)<br />
    <select name="term">
        <option value="6">6</option>
        <option value="12">12</option>
        <option value="24">24</option>
        <option value="36">36</option>
    </select>
</label><br />
<label>Тип<br />
    <select name="type">
        <option value="STANDARD">Стандартный</option>
        <option value="CURRENCY">Валютный</option>
        <option value="PREMIUM">Премиальный</option>
        <option value="TRAVEL">Туристический</option>
    </select>
</label><br />
<label>Уровень<br />
    <select name="level">
        <option value="LIGHT">light</option>
        <option value="STANDARD">standard</option>
        <option value="GOLD">gold</option>

    </select>
</label><br />
<%--
кнопки type - submit отправляет пост запрос при нажатии на кнопку
прописал "name" по нему в методе "doPost" отлавливал нажатие кнопки
--%>
    <br/>
    <button name="cancel" type="submit">Назад</button>
    <button name="enter"  type="submit">Рассчитать</button>

</form>

</body>
</html>

