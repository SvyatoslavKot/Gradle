<%--
  Created by IntelliJ IDEA.
  User: Svyat
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главноая</title>
</head>
<body>
<jsp:include page="/views/include/header.jsp"/>

<div>
    <%--
   встроенныё javaCod показывает последнего добавленного юзера
--%>
    <jsp:useBean id="client" class="app.entities.Client" scope="session"/>

    <p> </p>
    <div>
        <div>
            <h2>Login</h2>
        </div>
        <%--
       JavaCod
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
       форма входа
       метод "post" отправляет пост-запрос в сервлет
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
            <button name="enter"  type="submit">Submit</button>
            <button name="register" type="submit">register</button>

        </form>
    </div>
</div>
</body>
<jsp:include page="/views/include/footer.jsp"/>
</html>
