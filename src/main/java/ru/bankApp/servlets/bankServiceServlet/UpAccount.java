package ru.bankApp.servlets.bankServiceServlet;

import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.Client;
import ru.bankApp.servlets.HtmlPage;
import ru.bankApp.servlets.include.NavBarServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/bank_app/main/payment/upAccount")
public class UpAccount extends HttpServlet {/*
    NavBarServlet navBar = new NavBarServlet();
    Client client;
    Account account;
    ServiceAccountCollection serviceAccount = new ServiceAccountCollection();

    String operation = "";
    String sumMsg = "";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();
        client = (Client) session.getAttribute("client");
        account = serviceAccount.getAccountByNum(req.getParameter("accountNum"));

        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);
        form(resp);
        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("send")!=null){
            if (req.getParameter("sum")!=null && req.getParameter("sum").length()!=0){
                double sum = Double.parseDouble(req.getParameter("sum"));
                account.setMoney(sum);

                resp.sendRedirect("/bank_app/profile/accounts");
            }else {
                sumMsg = "Введите сумму";
                doGet(req,resp);
            }
        }
        if (req.getParameter("cancel")!=null){
           resp.sendRedirect("/bank_app/profile/accounts");
        }
    }
    private void form(HttpServletResponse resp) throws IOException {
       resp.getWriter().append( "<form method=\"post\">\n" +
               "<h3>Пополнение счёта</h3>" +
               "<label>Ваш счет: </label> "+ account.getAccount_num()+"<br>" +
               "<label>Сумма: <br />\n" +
               "<input type=\"text\"\n" +
               " name=\"sum\"\n></label>\n" + sumMsg +"<br />\n" +
               "<button name ='send' type='submit'>Пополнить</button> " + "<br />\n" +
               "<button name ='cancel' type='submit'>Мои счета</button> " +
               "</form>" );
    }*/
}
