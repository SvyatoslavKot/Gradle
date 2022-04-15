<%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главноая</title>
</head>
<body>
<jsp:include page="/views/include/header.jsp"/><%--вложенная страницы--%>

<div>
    <div>
        <div>
            <h2>Login</h2>
        </div>
        <%--
   встроенныё javaCod проверяет если пустой филд выводит сообщение
--%>
        <%
            if (request.getParameter("name")!= null){
                if (request.getParameter("name").isEmpty()){
                    out.println("<p>Заполните поле 'имя'!</p>");
                }else if (request.getParameter("pass")!= null){
                    if (request.getParameter("pass").isEmpty()){
                        out.println("<p>Заполните поле 'пароль'</p>");
                    }
                }
            }else {
                out.println("<p>Здравствуйте заполните форму</p>");
            }
        %>
        <%--
       форма входа метод "post" отправляет пост-запрос в сервлет
       --%>
        <form method="post">
            <label>Name:<br />
                <input type="text" name="name"><br />
            </label>
            <label>Password:<br />
                <input type="password" name="pass"><br />
            </label>
            <%--
       кнопки type - submit отправляет пост запрос при нажатии на кнопку
       прописал "name" по нему в методе "doPost" отлавливал нажатие кнопки
       --%>
            <button  name="enter"  type="submit">Submit</button>
            <button name="register" type="submit">register</button>

        </form>
    </div>
</div>
<jsp:include page="/views/include/footer.jsp"/>
</body>

</html>
