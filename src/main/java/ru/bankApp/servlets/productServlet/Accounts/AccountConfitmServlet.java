package ru.bankApp.servlets.productServlet.Accounts;

import ru.bankApp.app.bankApp.Bank;

import ru.bankApp.app.entities.accountFactory.Account;
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

@WebServlet("/bank_app/account/confirm_account")
public class AccountConfitmServlet extends HttpServlet {
    NavBarServlet navBar = new NavBarServlet();
    Bank bank = Bank.getInstance();
    Account account;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        account = (Account) session.getAttribute("accountCalk");

        resp.getWriter().write(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);
        resp.getWriter().append("<h4>Форма оформления кредита</h4><br>");
        if (account!=null){
            formConfAccount(resp);
        }else {
            resp.getWriter().append("<h5>Для вас нет подходящих предложений</h5>");
        }

        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("confirm")!=null){
            bank.getBankCollection().getAccountList().add(account);

            session.removeAttribute("accountCalk");
            resp.sendRedirect("/bank_app/account/main");
        }
        if (req.getParameter("cancel")!=null){
            session.removeAttribute("creditCalck");
            resp.sendRedirect("/bank_app/account/main");
        }
    }
    private void formConfAccount (HttpServletResponse resp) throws IOException {
        resp.getWriter().append("<form method=\"post\">\n" +
                "    <h4>Вам оформлен счет</h4>\n" +
                "    <label> Название :</label> "+account.getName()+" <br/>\n" +
                "    <label> Номер счета :</label> "+account.getAccount_num()+"<br/>\n" +
                "    <label> CashBack :</label> "+account.getCashBack()+" <br/>\n" +
                "    <label> Срок действия :</label> "+account.getCredit_term()+"<br/>\n" +
                "    <label> Плата за обслуживание :</label> "+account.getPayment()+"<br/>\n" +
                "    <label> Ваш pin :</label> <br/>\n" +
                "    <button name=\"confirm\" type=\"submit\">Подтвердить</button>\n" +
                "    <button name=\"cancel\" type=\"submit\">Отказаться</button>\n" +
                "\n" +
                "</form>");
    }
}
