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
<jsp:include page="/views/include/header.jsp"/>
<div>
    <div>
        <h2>Главная страница по работе со счетами</h2>
    </div>
    <div>
        <form method="post">
            <h4>Здесь вы можете отрыть счет</h4>
            <%--
  кнопки type - submit отправляет пост запрос при нажатии на кнопку
  прописал "name" по нему в методе "doPost" отлавливал нажатие кнопки
  --%>
            <button name="open"  type="submit">Открыть счёт</button> <br/>
            <br/>
            <button name="putMoney"  type="submit">Пополнить</button> <br/>
            <br/>
            <button name="Inf"  type="submit">Информация по счёту</button> <br/>
            <br/>
            <button name="cancel" type="submit">Назад</button> <br/>
        </form>
    </div>
<jsp:include page="/views/include/footer.jsp"/>

</div>


</body>
</html>
