package app.servlets;

import app.bankApp.serviceBank.PasswordCheck;
import app.entities.Client;
import app.servlets.include.NavBarServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author SvyatoslavK
 * Servlet страницы профиля клиента
 * Mapping прописан в @WebServlet
 * */

@WebServlet("/bank_app/profileview")
public class ProfileServlet extends HttpServlet {
    NavBarServlet navBar = new NavBarServlet();
    String nickName;
    String password;
    PasswordCheck passwordCheck = new PasswordCheck();
    Client client;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();
        client = (Client) session.getAttribute("client");
        resp.getWriter().append(HtmlPage.START.htmlElement);
        navBar.navbar(resp,req);
        resp.getWriter().append("" +
                "<h4>Окно Профиля</h4> <div>" + "<a href = '/bank_app/main2'>изменить</a>" +
                "Имя: " + client.getUserName() +"<br>" +
                "Фамилия: " + client.getLastName() +"<br>" +
                "Login: " + client.getNickName() +"<br>" +
                "Phone: "+ client.getMobilePhone() + "<br></div>" +
                "Id: "+ client.getId() + "<br></div>" +
                "<br/>\n" +
                "            <button onclick=location.href='/bank_app/profile/credit' >Кредиты</button><br/>\n" +
                "        <br/>\n" +
                "            <button onclick=location.href='/bank_app/profile/accounts'>Счета</button><br/>\n" +
                "        <br/>\n" +
                "            <button onclick=location.href='/bank_app/profileview'>Страховки</button><br/>\n" +
                "        <br/>\n" +
                "            <button onclick=location.href='/bank_app/main/payment'>Платежи</button><br/>\n" +
                "        <br/>\n" +
                "        <form method=\"post\">\n" +
                "            <button name=\"exit\" type=\"submit\">Выйти</button>\n" +
                "        </form>\n" +
                "    </div>");

        resp.getWriter().append(HtmlPage.END.htmlElement);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("exit")!= null) {
            session.removeAttribute("client");
            resp.sendRedirect("/bank_app/main2");
        }
    }
}
