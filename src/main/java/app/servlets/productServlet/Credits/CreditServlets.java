package app.servlets.productServlet.Credits;

import app.servlets.HtmlPage;
import app.servlets.include.NavBarServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bank_app/credit/main")
public class CreditServlets extends HttpServlet {
    NavBarServlet navbar = new NavBarServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write(HtmlPage.START.getHtmlElement());
        navbar.navbar(resp,req);
        resp.getWriter().append("<form method=\"post\">\n" +
                "    <h3>Кредиты</h3>\n" +
                "    <button name=\"openCredit\", type=\"submit\">Взять кредит</button>\n" +
                "</form>");
        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("openCredit")!= null){
            resp.sendRedirect("/bank_app/credit/open");
        }
    }
}
