package ru.bankApp.servlets.profileView;

import ru.bankApp.app.bankApp.Bank;
import ru.bankApp.app.bankApp.bankCollection.SortAccount;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.Client;
import ru.bankApp.servlets.HtmlPage;
import ru.bankApp.servlets.include.NavBarServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet("/bank_app/profile/accounts")
public class ProfileAccountView extends HttpServlet {/*
    Bank bank = Bank.getInstance();
  //  ReadAccount ra = ReadAccount.getInstance();
    NavBarServlet navBar = new NavBarServlet();
    Client client;
    ServiceAccountCollection serviceAccount = new ServiceAccountCollection();

    SortAccount sortAccount = new SortAccount();
    ArrayList<Account> sortList;
    ArrayList<Account> accounts;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
       // ra.readBD(bank);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();
        client = (Client) session.getAttribute("client");

        accounts = serviceAccount.getAccountByClient(client);
            System.out.println(accounts.size());

        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);
        if (accounts.size()==0 ){
            resp.getWriter().append("<h4>Нет открытых счетов</h4><br>" +
                    "<button onclick=\"location.href=\'/bank_app/account/open\'\">Открыть счёт</button>");
        }else{
            resp.getWriter().append("<form method=\"get\">\n" +
                    "        <label>Сортировать</label>\n" +
                    "        <select name= \"sortParam\" title=\"сортировка\"  resource=\"sss\" >\n" +
                    "            <option value=\"4\">по дате</option>\n" +
                    "            <option value=\"1\">возрастанию баланса</option>\n" +
                    "            <option value= \"2\">уменьшению баланса</option>\n" +
                    "            <option value=\"3\">по названию</option>\n" +
                    "        </select>\n" +
                    "        <button name=\"sortButton\" type=\"submit\">Cортировать</button>\n" +
                    "    </form>");
            if (req.getParameter("sortButton")!= null){
                if (req.getParameter("sortParam").equals("1")){
                    sortList = (ArrayList<Account>) sortAccount.sortByMoneyHight(accounts);
                    System.out.println(sortList.get(1));
                }else if (req.getParameter("sortParam").equals("2")) {
                    sortList = (ArrayList<Account>) sortAccount.sortByMoneyLow(accounts);
                }else if (req.getParameter("sortParam").equals("3")) {
                    sortList = (ArrayList<Account>) sortAccount.sortByName(accounts);
                }else if (req.getParameter("sortParam").equals("4")) {
                    sortList = (ArrayList<Account>) sortAccount.sortByPaymentLow(accounts);
                }
            }else {
                sortList = (ArrayList<Account>) sortAccount.sortByPaymentHeight(accounts);
            }

            tableAccount(req,resp);
        }

        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }

    private void tableAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().setAttribute("accountsList", sortList);
        resp.getWriter().append(
                "<h5>Счета</h5>"+
                        "        <table border='1'>"+
                        "                <tr>\n" +
                        "                    <td width=\"180\">Названиеи</td>\n" +
                        "                    <td width=\"150\">Номер счета</td>\n" +
                        "                    <td width=\"150\">Баланс</td>\n" +
                        "                    <td width=\"150\">Дата открытия</td>\n" +
                        "                    <td width=\"150\">Срок обслуживания</td>\n" +
                        "                    <td width=\"150\">Стоимость обслуживания</td>\n" +
                        "                    <td width=\"150\">CashBack</td>\n" +
                        "                    <td width=\"150\">Pin</td>\n" +
                        "                </tr>\n" +
                        "           \n" );
        if (sortList!=null && sortList.size()!=0 ){
            for (int i = 0; i <=sortList.size(); i++){
                System.out.println(sortList.size());
                Account a = sortList.get(i);
                resp.getWriter().append(

                        "                <tr>\n" +
                                "                    <td width=\"180\">"+a.getName()+"</td>\n" +
                                "                    <td width=\"150\">"+a.getAccount_num()+"</td>\n" +
                                "                    <td width=\"150\">"+String.format("%.2f",a.getMoney_in_account())+"</td>\n" +
                                "                    <td width=\"150\">"+dateFormat.format(a.getDate())+"</td>\n" +
                                "                    <td width=\"150\">"+a.getCredit_term()+"</td>\n" +
                                "                    <td width=\"150\">"+a.getPayment()+"</td>\n" +
                                "                    <td width=\"150\">"+a.getCashBack()+"</td>\n" +
                                "                    <td width=\"150\"></td>\n" +
                                "                    <td width=\"150\"><a href='/bank_app/profile/account?indexAccount="+i+"'>Выбрать</a></td>\n"+
                                "                </tr>\n" +
                                "           \n" );

            }

        }
        resp.getWriter().append("</table>");
    }
*/
}
