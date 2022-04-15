<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Form</title>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html; charset=UTF-8" />
</head>

<jsp:include page="/views/include/header.jsp"/>
<body>
<div>
    <div>
        <h3>Регистрация</h3>
    </div>
    <div ><%--Форма с методом пост--%>
        <form method="post">
            <label>Name:<br />
                <input type="text"
                       name="name"
                                <%--проверяет если при перезагрузке филд был заполнен берет значение из реквеста--%>
                       value="<% if(request.getAttribute("name")!= null){out.print(request.getAttribute("name"));}%>">
                <%--проверяет если при отправке запроса параметр пустой выводит сообщение--%>
                <%if (request.getParameter("name") != null && request.getParameter("name").isEmpty()){
                            out.print("<p>заполни</p>");}
                %><br />
            </label>
            <label>Last Name:<br />
                <input type="text"
                       name="lastName"
                       value="<% if(request.getAttribute("lastName")!= null){out.print(request.getAttribute("lastName"));}%>">
                <%
                    if (request.getParameter("lastName") !=null && request.getParameter("lastName").isEmpty()) {
                        out.print("<p> заполни</p>");}
                %><br />
            </label>

            <label>Nickname:<br />
                <input type="text" name="nickName"
                       value="<% if(request.getAttribute("nickName")!= null){out.print(request.getAttribute("nickName"));}%>">
                <%
                    if (request.getParameter("nickName") !=null && request.getParameter("nickName").isEmpty()) {
                        out.print("<p>заполни</p>");}
                %><br />
            </label>
            <label>Password:<br />
                <input type="password" name="password1">
                     <%--проверяет если при отправке запроса пароль пустой выводит сообщение--%>
                <% if (request.getParameter("password1") !=null && request.getParameter("password1").isEmpty()) {
                        out.print("<p> введите пароль</p>");}
                %><br />
                <input type="password" name="password2">
                <%
                    if (request.getParameter("password2") !=null && request.getParameter("password2").isEmpty()) {
                        out.print("<p>заполни</p>");}
                %><br />
        </label>
            <%--
       кнопки type - submit отправляет пост запрос при нажатии на кнопку
       прописал "name" по нему в методе "doPost" отлавливал нажатие кнопки
       --%>
            <button name="enter"  type="submit">Register</button>
            <button name="register" type="submit">Cancel</button>

        </form>

        </form>
    </div>
</div>

</body>
<jsp:include page="/views/include/footer.jsp"/>
</html>
