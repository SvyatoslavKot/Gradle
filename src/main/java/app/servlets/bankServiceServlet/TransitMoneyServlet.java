package app.servlets.bankServiceServlet;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadAccount;
import app.bankApp.DBtextformat.WriteAccount;
import app.bankApp.bankCollection.ServiceAccountCollection;
import app.bankApp.exeption.AccountOperationExeption;
import app.bankApp.recieptBridge.RecieptAccountBridge;
import app.bankApp.recieptBridge.TypeOperetion;
import app.bankApp.serviceBank.MoneyOperation;
import app.entities.Account;
import app.entities.Client;
import app.entities.Reciept;
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
    WriteAccount wa  = WriteAccount.getInstance();

    Reciept reciept;
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
        client = (Client) session.getAttribute("client");
        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);

        if (client != null){
            accountsSender = serviceAccount.getAccountByClient(client);

        if (session.getAttribute("typeTransit").equals("ourSelf")) {
            accountsAddressee = serviceAccount.getAccountByClient(client);
            resp.getWriter().append("<h4>Перевод средств между свомим счетами</h4>\n");
            senderAcc(req, resp);
            addressee(req, resp);
        }
        else if(session.getAttribute("typeTransit").equals("clientBank")){
            resp.getWriter().append("<h4>Перевод клиенту банка по номеру счёта</h4>\n");
            senderAcc(req, resp);
            resp.getWriter().append("<br><label>Счет зачисления:<br><input type=\"text\" name=\"account_2\"></label>\n");
            resp.getWriter().append("<br><label>Cумма перевода:<br><input type=\"text\" name=\"sum\"></label>\n" +
                    "<button name=\"send\" type=\"submit\">Перевести</button>\n</form>");
        }
        else if(session.getAttribute("typeTransit").equals("clientOtherBank")){
            resp.getWriter().append("<h4>Перевод клиенту другого банка по номеру счёта</h4>\n");
            senderAcc(req, resp);
            resp.getWriter().append("<br><label>Счет зачисления:<br><input type=\"text\" name=\"account_2\"></label>\n");
            resp.getWriter().append("<br><label>Cумма перевода:<br><input type=\"text\" name=\"sum\"></label>\n" +
                    "<button name=\"send\" type=\"submit\">Перевести</button>\n</form>");
            }
        }
        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("send")!=null){
            if (req.getParameter("sum")==null && req.getParameter("sum").length()==0){
                msgText = "Введите Сумму перевода";
                doGet(req, resp);
            }else {
                msgText = "";
            }
            if (req.getParameter("account_1")==null && req.getParameter("account_1").length()==0){
                msgText = "Выбирете счет списания";
                doGet(req, resp);
            }else {
                msgText = "";
            }
            if (req.getParameter("account_2")==null && req.getParameter("account_2").length()==0){
                msgText = "Выбирете счет зачисления";
                doGet(req, resp);
            }else {
                msgText = "";
            }
            if (req.getParameter("sum")!=null && req.getParameter("sum").length()!=0 &&
                req.getParameter("account_1")!=null && req.getParameter("account_1").length()!=0 &&
                req.getParameter("account_2")!=null && req.getParameter("account_2").length()!=0){

                double sum  = Double.parseDouble(req.getParameter("sum"));
                Account accountSender = serviceAccount.getAccountByNum(req.getParameter("account_1"));
                if (req.getSession().getAttribute("typeTransit").equals("ourSelf") || req.getSession().getAttribute("typeTransit").equals("clientBank")){
                    Account accountAddressee = serviceAccount.getAccountByNum(req.getParameter("account_2"));
                    if (accountSender!= null && accountAddressee !=null){
                        try {
                            if(moneyOperation.AccountTransferMoney(accountSender,accountAddressee, sum)){
                                if (req.getSession().getAttribute("typeTransit").equals("ourSelf")){
                                    reciept = new Reciept(new RecieptAccountBridge(), "Account", TypeOperetion.ACCOUNT_TRANSFER_BETWEEN_OWN.type,
                                            "Перевод на счёт " + accountAddressee.getAccountNumber(), String.valueOf(sum),
                                            accountSender.getAccountNumber(), client.getMobilePhone());
                                    reciept = new Reciept(new RecieptAccountBridge(), "Account", TypeOperetion.ACCOUNT_TRANSFER_BETWEEN_OWN.type,
                                            "Перевод от " + accountSender.getAccountNumber(), String.valueOf(sum),
                                            accountAddressee.getAccountNumber(), accountAddressee.getLoginHolder());
                                }
                                if (req.getSession().getAttribute("typeTransit").equals("clientBank")){
                                    reciept = new Reciept(new RecieptAccountBridge(), "Account", TypeOperetion.ACCOUNT_TRANSFER.type,
                                            "Перевод на счёт " + accountAddressee.getAccountNumber(), String.valueOf(sum),
                                            accountSender.getAccountNumber(), client.getMobilePhone());
                                    reciept = new Reciept(new RecieptAccountBridge(), "Account", TypeOperetion.ACCOUNT_PLUS.type,
                                            "Перевод от " + accountSender.getAccountNumber(), String.valueOf(sum),
                                            accountAddressee.getAccountNumber(), accountAddressee.getLoginHolder());
                                }
                                wa.writeAccount(Bank.getInstance());
                                resp.sendRedirect("/bank_app/main/payment");
                            }
                        } catch (AccountOperationExeption e) {
                            msgText = e.getMessage();
                            e.printStackTrace();
                            doGet(req, resp);
                        }
                    }else {  msgText = "не найдет счет";
                        doGet(req, resp);
                    }
                }
                if (req.getSession().getAttribute("typeTransit").equals("clientOtherBank")){
                    if (accountSender.getMoney(sum)){
                        reciept = new Reciept(new RecieptAccountBridge(), "Account", TypeOperetion.ACCOUNT_TRANSFER.type,
                                "Перевод на счёт " +  req.getParameter("account_2"), String.valueOf(sum),
                                accountSender.getAccountNumber(), client.getNickName());
                        wa.writeAccount(Bank.getInstance());
                        resp.sendRedirect("/bank_app/main/payment");
                    }
                    else {
                        msgText = "Недостаточно средств на счёте";
                        doGet(req, resp);
                    }
                }

            }else {
                    msgText = "Заполните форму!";
                    doGet(req, resp);
            }
        }
    }

    public void senderAcc(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().append(
                "<h6>"+msgText+"</h6>\n" +
                "    \n" +
                "    <form method=\"post\">\n" +
                "    <label>Счет списания</label><br/>\n" +
                "    <select name=\"account_1\">\n");
        for (Account account : accountsSender){
            resp.getWriter().append(" <option value=\""+account.getAccountNumber()+"\">"+account.getAccountNumber()+"</option>\n");
        }resp.getWriter().append("    </select>\n<br>" );
    }
    public void addressee (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().append(
                "    <label>Счет зачисления</label><br/>\n" +
                        "    <select name=\"account_2\">\n" );
        for (Account account2 : accountsAddressee){
            resp.getWriter().append(" <option value=\""+account2.getAccountNumber()+"\">"+account2.getAccountNumber()+"</option>\n");
        }
        resp.getWriter().append("    </select>\n<br>" );

        resp.getWriter().append("<br><label>Cумма перевода:<br><input type=\"text\" name=\"sum\"></label>\n" +
                "<button name=\"send\" type=\"submit\">Перевести</button>\n</form>");

    }
}
