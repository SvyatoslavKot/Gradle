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

@WebServlet("/bank_app/payment/taransit/main")
public class TransitMainServlet extends HttpServlet {
    NavBarServlet navBar = new NavBarServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();

        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);

            resp.getWriter().append("<div>\n" +
                    "    <form method=\"post\">\n" +
                    "        <button  type=\"submit\" name=\"ourSelf\">Между своими счетами</button>\n" +
                    "        <br/>\n" +
                    "        <button type=\"submit\" name=\"clientBank\">Клиенту Банка</button>\n" +
                    "        <br/>\n" +
                    "        <button type=\"submit\" name=\"clientOtherBank\">Клиенту другого банка</button>\n" +
                    "    </form>\n" +
                    "</div>");

        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (req.getParameter("ourSelf")!=null){
           session.setAttribute("typeTransit", "ourSelf");
           resp.sendRedirect("/bank_app/payment/taransit");
        }else if (req.getParameter("clientBank")!=null){
            session.setAttribute("typeTransit", "clientBank");
            resp.sendRedirect("/bank_app/payment/taransit");
        }else if (req.getParameter("clientOtherBank")!=null){
            session.setAttribute("typeTransit", "clientOtherBank");
            resp.sendRedirect("/bank_app/payment/taransit/main");
        }
    }
}
