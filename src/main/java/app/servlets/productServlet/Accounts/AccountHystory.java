package app.servlets.productServlet.Accounts;

import app.bankApp.bankCollection.ServiceRecipt;
import app.bankApp.exeption.RecieptNullEx;
import app.entities.Account;
import app.entities.Reciept;
import app.servlets.HtmlPage;
import app.servlets.include.NavBarServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/bank_app/main/accountHistory")
public class AccountHystory extends HttpServlet {
    ServiceRecipt serviceRecipt = new ServiceRecipt();
    NavBarServlet navBar = new NavBarServlet();
    List<Reciept> list ;
    private String title = "История";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp, req);
        try {
            list = serviceRecipt.getListByAccount(req.getParameter("accountNum"));
        } catch (RecieptNullEx e) {
            e.printStackTrace();
            title = e.getMessage();
        }
        resp.getWriter().append("<h5>"+title+"</h5>");
        historyTable(req, resp);
        resp.getWriter().append("<button onclick=\"location.href=\'/bank_app/profile/account\'\">Назад</button>");

        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }

    void historyTable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().append(
                        "        <table border='1'>"+
                        "                <tr>\n" +
                        "                    <td width=\"180\">Название</td>\n" +
                        "                    <td width=\"150\">Тип операции</td>\n" +
                        "                    <td width=\"150\">дата</td>\n" +
                        "                    <td width=\"150\">Значение</td>\n" +
                        "                </tr>\n" +
                        "           \n" );
            for (Reciept r : list){
                resp.getWriter().append(
                        "                <tr>\n" +
                                "                    <td width=\"180\">"+r.getTitle()+"</td>\n" +
                                "                    <td width=\"150\">"+r.getType()+"</td>\n" +
                                "                    <td width=\"150\">"+dateFormat.format(r.getDate())+"</td>\n" +
                                "                    <td width=\"150\">"+r.getValue()+"</td>\n" +
                                "                </tr>\n" +
                                "           \n" );
            }
            resp.getWriter().append("</table>");
        }
}
