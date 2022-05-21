package ru.bankApp.servlets.productServlet.Accounts;

import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.servlets.HtmlPage;
import ru.bankApp.servlets.include.NavBarServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet("/bank_app/profile/account")
public class AccountViewServlet extends HttpServlet {/*
    NavBarServlet navBar = new NavBarServlet();
    ServiceAccountCollection serviseAccount = new ServiceAccountCollection();
   //WriteAccount wa = WriteAccount.getInstance();

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Account account;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        Integer index = Integer.valueOf(req.getParameter("indexAccount"));
        ArrayList<Account> accounts = (ArrayList<Account>) req.getSession().getAttribute("accountsList");
        account = accounts.get(index);

        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);
        resp.getWriter().append("" +
                "<p>" +
                "Название: " +account.getName() + "<br>" +
                "Номер счета: " + account.getAccount_num()+ "<br>" +
                "Дата открытия:" + dateFormat.format(account.getDate()) + "<br>" +
                "Бланс:" + account.getMoney_in_account() + "<br>" +
                "</p>" +
                "<form method='post'>" +
                "<button name = 'close' type= 'submit'>Закрыть счёт</button>" + "<br>" +
                "<button name = 'history' type= 'submit'>История операций</button>" + "<br>" +
                "<button name = 'upAcc' type= 'submit'>Пополнить</button>" + "<br>" +
                "<button name = 'cancel' type= 'submit'>Назад</button>" +
                "</form>");

        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("cancel")!=null){
            req.getSession().removeAttribute("accountsList");
            resp.sendRedirect("/bank_app/profile/accounts");
        }
        if (req.getParameter("close")!=null){
            serviseAccount.removeAccount(account);
           // wa.writeAccount(Bank.getInstance());
            req.getSession().removeAttribute("accountsList");
            resp.sendRedirect("/bank_app/profile/accounts");
        }
        if (req.getParameter("upAcc")!=null){
            resp.sendRedirect("/bank_app/main/payment/upAccount?accountNum="+account.getAccount_num());
        }
        if (req.getParameter("history")!=null){
            resp.sendRedirect("/bank_app/main/accountHistory?accountNum="+account.getAccount_num());
        }
    }*/
}