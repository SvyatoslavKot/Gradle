package app.servlets.bankServiceServlet;

import app.entities.Client;
import app.servlets.HtmlPage;
import app.servlets.include.NavBarServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/bank_app/main/payment")
public class PaymentViewServlet extends HttpServlet {
    NavBarServlet navBar = new NavBarServlet();
    Client client;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();
        client = (Client) session.getAttribute("client");

        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);
        if (client!=null){
        resp.getWriter().append("<div>\n" +
                "        <h3>Раздел платежи</h3>\n" +
                "    </div>\n" +
                "\n" +
                "        <button onclick=\"location.href='/bank_app/payment/taransit/main'\">Перевести</button>\n" +
                "        <br/>\n" +
                "        <button onclick=\"location.href='/bank_app/main/payment'\">Оплатить</button>\n" +
                "\n" +
                "</div>");}else {
            resp.getWriter().append("<h4>Авторизуйтесь</h4>");
        }

        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
