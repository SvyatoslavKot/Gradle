package app.servlets;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadAccount;
import app.bankApp.DBtextformat.ReadClient;
import app.bankApp.DBtextformat.ReaderCredit;
import app.bankApp.bankCollection.ServiceAccountCollection;
import app.bankApp.bankCollection.ServiceCreditCollection;
import app.entities.Account;
import app.entities.Client;
import app.entities.Credit;
import app.servlets.include.NavBarServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

/**
 * this servlet Admin window
 * show information about the number of client and products
 */
@WebServlet("/bank_app/admin")
public class AdminServlet extends HttpServlet {
    Bank bank = Bank.getInstance();
    ReadClient readClient = ReadClient.getInstance();
    ReaderCredit readerCredit = ReaderCredit.getInstance();
    ReadAccount readAccount = ReadAccount.getInstance();
    ServiceCreditCollection serisCredit = new ServiceCreditCollection();
    ServiceAccountCollection servisAccount = new ServiceAccountCollection();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        readAccount.readBD(bank);
        readClient.readBD(bank);
        readerCredit.readBD(bank);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NavBarServlet headerServlet = new NavBarServlet();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        HashMap<String, Client> clientList = bank.getBankCollection().getClientHashMap();
        ArrayList<Credit> credits = serisCredit.getAllCredits();
        ArrayList<Account> accounts = servisAccount.getAllAccounts();



        headerServlet.navbar(resp,req);
        resp.getWriter().append("<br><h4>Окно администратора</h4><br>"+
                "<p>Выберите список: </p>"+
                "<div>\n" +
                "    <form method=\"get\">\n" +
                "        <label>Сортировать</label>\n" +
                "        <select name= \"list\">\n" +
                "               <option disabled>Выберите</option>"+
                "            <option value=\"1\">Клиенты</option>\n" +
                "            <option value=\"2\">Кредиты</option>\n" +
                "            <option value= \"3\">Счета</option>\n" +
                "        </select>\n" +
                "        <button name=\"choseList\" type=\"submit\">Показать</button>\n" +
                "    </form>\n" +
                "</div>"
        );

        if (req.getParameter("list").equals("1")){
            resp.getWriter().append(
                        "<h5>Клиенты</h5>"+
                        "        <table border='1'>"+
                        "                <tr>\n" +
                        "                    <td width=\"100\">имя </td>\n" +
                        "                    <td width=\"100\">Фамилия</td>\n" +
                        "                    <td width=\"100\">Логин</td>\n" +
                        "                    <td width=\"100\">Id</td>\n" +
                        "                    <td width=\"100\">Пароль</td>\n" +
                        "                </tr>\n" +
                        "           \n" +
                        "        </table>");
            for (Map.Entry client : clientList.entrySet()){
                    Client c = (Client) client.getValue();
                    resp.getWriter().append(
                                    "        <table border='1'>"+
                                    "                <tr>\n" +
                                    "                    <td width=\"100\">"+c.getUserName()+"</td>\n" +
                                    "                    <td width=\"100\">"+c.getLastName()+"</td>\n" +
                                    "                    <td width=\"100\">"+c.getNickName()+"</td>\n" +
                                    "                    <td width=\"100\">"+c.getId()+"</td>\n" +
                                    "                    <td width=\"100\">"+c.getPassword()+"</td>\n" +
                                    "                </tr>\n" +
                                    "           \n" +
                                    "        </table>");

                }
            }
        else if (req.getParameter("list").equals("2")){
            resp.getWriter().append(
                            "<h5>Кредиты</h5>"+
                            "        <table border='1'>"+
                            "                <tr>\n" +
                            "                    <td width=\"150\">Названиеи</td>\n" +
                            "                    <td width=\"150\">Номер счета</td>\n" +
                            "                    <td width=\"150\">Сумма</td>\n" +
                            "                    <td width=\"150\">Проценты</td>\n" +
                            "                    <td width=\"150\">Дата открытия</td>\n" +
                            "                    <td width=\"150\">Срок</td>\n" +
                            "                    <td width=\"150\">Платёж</td>\n" +
                            "                    <td width=\"150\">ID держателя</td>\n" +
                            "                </tr>\n" +
                            "           \n" +
                            "        </table>");
            for (Credit credit : credits){
                resp.getWriter().append(
                        "        <table border='1'>"+
                                "                <tr>\n" +
                                "                    <td width=\"150\">"+credit.getCreditName()+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getAccountNumber()+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getAmount()+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getPtc()+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getOpeningDate()+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getCreditTerm()+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getPaymentMonth()+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getIdHolder()+"</td>\n" +

                                "                </tr>\n" +
                                "           \n" +
                                "        </table>");

            }
        }
        else if (req.getParameter("list").equals("3")){
            resp.getWriter().append(
                            "<h5>Счета</h5>"+
                            "        <table border='1'>"+
                            "                <tr>\n" +
                            "                    <td width=\"180\">Названиеи</td>\n" +
                            "                    <td width=\"150\">Номер счета</td>\n" +
                            "                    <td width=\"150\">Баланс</td>\n" +
                            "                    <td width=\"150\">Срок обслуживания</td>\n" +
                            "                    <td width=\"150\">Годовое обслуживание</td>\n" +
                            "                    <td width=\"150\">CashBack</td>\n" +
                            "                    <td width=\"150\">Id</td>\n" +
                            "                    <td width=\"150\">pin</td>\n" +
                            "                </tr>\n" +
                            "           \n" +
                            "        </table>");
            for (Account account : accounts){
                resp.getWriter().append(
                        "        <table border='1'>"+
                                "                <tr>\n" +
                                "                    <td width=\"180\">"+account.getNameAccount()+"</td>\n" +
                                "                    <td width=\"150\">"+account.getAccountNumber()+"</td>\n" +
                                "                    <td width=\"150\">"+account.getMoneyInAccount()+"</td>\n" +
                                "                    <td width=\"150\">"+account.getCreditTerm()+"</td>\n" +
                                "                    <td width=\"150\">"+account.getPayment()+"</td>\n" +
                                "                    <td width=\"150\">"+account.getCashBack()+"</td>\n" +
                                "                    <td width=\"150\">"+account.getIdHolder()+"</td>\n" +
                                "                    <td width=\"150\">"+account.getPin()+"</td>\n" +

                                "                </tr>\n" +
                                "           \n" +
                                "        </table>");

            }
        }

    }
}
