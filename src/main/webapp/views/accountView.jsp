<%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AccountView</title>
</head>
<body>
<label>Сумма:<br />
    <input type="text" name="sum"><br />
</label>
<label>Срок:<br />
    <input type="text" name="term"><br />
</label>
<label>Тип:<br />
    <input type="text" name="type"><br />
</label>
<%--
кнопки type - submit отправляет пост запрос при нажатии на кнопку
прописал "name" по нему в методе "doPost" отлавливал нажатие кнопки
--%>
<button name="enter"  type="submit">Рассчитать</button>
<button name="register" type="submit">Назад</button>
</body>
</html>
