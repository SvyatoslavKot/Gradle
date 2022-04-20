package app.servlets.bankServiceServlet;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadAccount;
import app.bankApp.bankCollection.ServiceAccountCollection;
import app.bankApp.exeption.AccountOperationExeption;
import app.bankApp.serviceBank.MoneyOperation;
import app.entities.Account;
import app.entities.Client;
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
import java.util.Set;

@WebServlet("/bank_app/payment/taransit")
public class TransitMoneyServlet extends HttpServlet {
    Client client;
    NavBarServlet navBar = new NavBarServlet();
    ArrayList<Account> accountsSender;
    ArrayList<Account> accountsAddressee;
    ServiceAccountCollection serviceAccount = new ServiceAccountCollection();
    MoneyOperation moneyOperation = new MoneyOperation();
    ReadAccount ra = ReadAccount.getInstance();
     private String msgText = "";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ra.readBD(Bank.getInstance());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();
        Client client = (Client) session.getAttribute("client");
        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);

        if (client != null){
            accountsSender = serviceAccount.getAccountByClient(client);
            System.out.println(accountsSender.size());
            resp.getWriter().append("<h4>Перевод средств между свомим счетами</h4>\n" +
                    "<h6>"+msgText+"</h6>\n" +
                    "    \n" +
                    "    <form method=\"post\">\n" +
                    "    <label>Счет списания</label><br/>\n" +
                    "    <select name=\"account_1\">\n");
            for (Account account : accountsSender){
                resp.getWriter().append(" <option value=\""+account.getAccountNumber()+"\">"+account.getAccountNumber()+"</option>\n");
            }resp.getWriter().append("    </select>\n" );

        if (session.getAttribute("typeTransit").equals("ourSelf")) {
                accountsAddressee= serviceAccount.getAccountByClient(client);
                resp.getWriter().append(
                        "    <label>Счет зачисления</label><br/>\n" +
                        "    <select name=\"account_2\">\n" );
                for (Account account2 : accountsAddressee){
                    resp.getWriter().append(" <option value=\""+account2.getAccountNumber()+"\">"+account2.getAccountNumber()+"</option>\n");
                }
                resp.getWriter().append("    </select>\n" );
            }


            resp.getWriter().append("<label>Cумма перевода:<input type=\"text\" name=\"sum\"></label>\n" +
                    "<button name=\"send\" type=\"submit\">Перевести</button>\n</form>");



        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("send")!=null){
            if (req.getParameter("sum")==null && req.getParameter("sum").isEmpty()){
                msgText = "Введите Сумму перевода";
                doGet(req, resp);
            }else {
                msgText = "";
            }
            if (req.getParameter("account_1")==null && req.getParameter("account_1").isEmpty()){
                msgText = "Выбирете счет списания";
                doGet(req, resp);
            }else {
                msgText = "";
            }
            if (req.getParameter("account_2")==null && req.getParameter("account_2").isEmpty()){
                msgText = "Выбирете счет зачисления";
                doGet(req, resp);
            }else {
                msgText = "";
            }
            if (req.getParameter("sum")!=null && !req.getParameter("sum").isEmpty() &&
                    req.getParameter("account_1")!=null && !req.getParameter("account_1").isEmpty()&&
                    req.getParameter("account_2")!=null && !req.getParameter("account_2").isEmpty()){
                double sum  = Double.parseDouble(req.getParameter("sum"));
                Account accountSender = serviceAccount.getAccountByNum(req.getParameter("account_1"));
                Account accountAddressee = serviceAccount.getAccountByNum(req.getParameter("account_2"));
                if (accountSender!= null && accountAddressee !=null){
                    try {
                        moneyOperation.AccountTransferMoney(accountSender,accountAddressee, sum);
                        resp.sendRedirect("/bank_app/main/payment");
                    } catch (AccountOperationExeption e) {
                        msgText = e.getMessage();
                        e.printStackTrace();
                        doGet(req, resp);
                    }
                }else {  msgText = "неидефицирвал счета";
                    doGet(req, resp);}
            }else {
                    msgText = "Заполните форму!";
                    doGet(req, resp);
            }
        }
    }
}
