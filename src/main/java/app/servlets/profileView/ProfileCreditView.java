package app.servlets.profileView;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadClient;
import app.bankApp.DBtextformat.ReaderCredit;
import app.bankApp.bankCollection.ServiceCreditCollection;
import app.bankApp.bankCollection.SortCreditList;
import app.entities.Client;
import app.entities.Credit;
import app.servlets.HtmlPage;
import app.servlets.include.NavBarServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/bank_app/profile/credit")
public class ProfileCreditView extends HttpServlet {
    NavBarServlet navBar = new NavBarServlet();
    Client client;
    ServiceCreditCollection seviceCredit = new ServiceCreditCollection();
    Bank bank = Bank.getInstance();
    ReaderCredit rc = ReaderCredit.getInstance();
    SortCreditList sortCreditList = new SortCreditList();
    ArrayList<Credit> sortList;
    ArrayList<Credit> credits;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        rc.readBD(bank);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();
        client = (Client) session.getAttribute("client");
        credits = seviceCredit.getAccountByClient(client);

        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);
        resp.getWriter().append("<div>\n" +
                "    <form method=\"get\">\n" +
                "        <label>Сортировать</label>\n" +
                "        <select name= \"sortParam\">\n" +
                "            <option value=\"4\">по дате</option>\n" +
                "            <option value=\"1\">возрастанию задолжности</option>\n" +
                "            <option value= \"2\">уменьшению задолжности</option>\n" +
                "            <option value=\"3\">по названию</option>\n" +
                "        </select>\n" +
                "        <button name=\"sortButton\" type=\"submit\">Cортировать</button>\n" +
                "    </form>\n" +
                "</div>");
        if (req.getParameter("sortButton")!= null){
            if (req.getParameter("sortParam").equals("1")){
                sortList = (ArrayList<Credit>) sortCreditList.sortByAmountLow(credits);
                System.out.println(sortList.get(1));
            }else if (req.getParameter("sortParam").equals("2")) {
                sortList = (ArrayList<Credit>) sortCreditList.sortByAmountHight(credits);
            }else if (req.getParameter("sortParam").equals("3")) {
                sortList = (ArrayList<Credit>) sortCreditList.sortByName(credits);
            }else if (req.getParameter("sortParam").equals("4")) {
                sortList = (ArrayList<Credit>) sortCreditList.sortByDate(credits);
            }
        }else {
            sortList = (ArrayList<Credit>) sortCreditList.sortByDate(credits);
        }

        creditTable(req,resp);
        resp.getWriter().append(HtmlPage.END.getHtmlElement());

    }

    private void creditTable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().append(
                "<h5>Кредиты</h5>"+
                        "        <table border='1'>"+
                        "                <tr>\n" +
                        "                    <td width=\"150\">Названиеи</td>\n" +
                        "                    <td width=\"150\">Номер счета</td>\n" +
                        "                    <td width=\"150\">Задолженность</td>\n" +
                        "                    <td width=\"150\">Проценты</td>\n" +
                        "                    <td width=\"150\">Дата открытия</td>\n" +
                        "                    <td width=\"150\">Срок погашения</td>\n" +
                        "                    <td width=\"150\">Платёж</td>\n" +
                        "                </tr>\n" +
                        "           \n" +
                        "        </table>");
        for (Credit credit : sortList){
            resp.getWriter().append(
                    "        <table border='1'>"+
                            "                <tr>\n" +
                            "                    <td width=\"150\">"+credit.getCreditName()+"</td>\n" +
                            "                    <td width=\"150\">"+credit.getAccountNumber()+"</td>\n" +
                            "                    <td width=\"150\">"+credit.getAmount()+"</td>\n" +
                            "                    <td width=\"150\">"+credit.getPtc()+"</td>\n" +
                            "                    <td width=\"150\">"+credit.getOpeningDate()+"</td>\n" +
                            "                    <td width=\"150\">"+credit.getCreditTerm()+"</td>\n" +
                            "                    <td width=\"150\"><a href=''>" +String.format("%.2f", credit.getPaymentMonth())+"</a></td>\n"+
                            "                </tr>\n" +
                            "           \n" +
                            "        </table>");

        }
    }

}
