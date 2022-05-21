package ru.bankApp.servlets.productServlet.Accounts;

import ru.bankApp.servlets.HtmlPage;
import ru.bankApp.servlets.include.NavBarServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bank_app/account/main")
public class AccountServlet extends HttpServlet {

    NavBarServlet headerServlet = new NavBarServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write(HtmlPage.START.getHtmlElement());
        headerServlet.navbar(resp,req);
        viewCredit(resp);
        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("open")!= null){
            resp.sendRedirect("/bank_app/account/open");
        }
        if (req.getParameter("infoAcc")!=null){
            resp.sendRedirect("/bank_app/main/payment/info");
        }
        if (req.getParameter("myAcc")!=null){
            resp.sendRedirect("/bank_app/profile/accounts");
        }
        if (req.getParameter("cancel")!= null){
            resp.sendRedirect("/bank_app/main2");
        }
    }
    private void viewCredit(HttpServletResponse resp) throws IOException {
        resp.getWriter().append("<div>\n" +
                "        <form method=\"post\">\n" +
                "            <h4>Здесь вы можете отрыть счет</h4>\n" +
                "            <button name=\"open\"  type=\"submit\">Открыть счёт</button> <br/>\n" +
                "            <br/>\n" +
                "            <button name=\"infoAcc\"  type=\"submit\">Информация</button> <br/>\n" +
                "            <br/>\n" +
                "            <button name=\"myAcc\"  type=\"submit\">Мои счёта</button> <br/>\n" +
                "            <br/>\n" +
                "            <button name=\"cancel\" type=\"submit\">Назад</button> <br/>\n" +
                "        </form>\n" +
                "    </div>");
    }
}
