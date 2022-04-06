<%--

--%>
<meta http-equiv="Content-Type" charset="UTF-8" content="text/html; charset=UTF-8" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="client" class="app.entities.Client" scope="session"/>

<html>
<head>
    <title>Register Form</title>
</head>
<jsp:include page="/views/include/header.jsp"/>
<body>
<div>
    <div>
        <h3>Регистрация</h3>
    </div>
    <div >
        <form method="post">

            <label>Name:<br />
                <input type="text" name="name"
                       value="<% if(request.getAttribute("name")!= null)
                       { out.print(request.getAttribute("name"));}  %>" >
                <%
                    if (request.getParameter("name") != null && request.getParameter("name").isEmpty()){
                            out.print("<p>заполни</p>");}
                %><br />
            </label>

            <label>Last Name:<br />
                <input type="text" name="lastName"
                    value="<% if(request.getAttribute("lastName")!= null)
                       { out.print(request.getAttribute("lastName"));}  %>" >
                <%
                    if (request.getParameter("lastName") !=null && request.getParameter("lastName").isEmpty()) {
                        out.print("<p> заполни</p>");}
                %><br />
            </label>

            <label>Nickname:<br />
                <input type="text" name="nickName"
                       value="<% if(request.getAttribute("nickName")!= null)
                       { out.print(request.getAttribute("nickName"));}  %>">
                <%
                    if (request.getParameter("nickName") !=null && request.getParameter("nickName").isEmpty()) {
                        out.print("<p>заполни</p>");}
                %><br />
            </label>
            <label>Password:<br />
                <input type="password" name="password1"
                       value="<% if(request.getAttribute("password1")!= null)
                       { out.print(request.getAttribute("password1"));}  %>">
                <%
                    if (request.getParameter("password1") !=null && request.getParameter("password1").isEmpty()) {
                        out.print("<p> заполни</p>");}
                %><br />
                <input type="password" name="password2"
                       value="<% if(request.getAttribute("password2")!= null)
                       { out.print(request.getAttribute("password2"));}  %>">
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
