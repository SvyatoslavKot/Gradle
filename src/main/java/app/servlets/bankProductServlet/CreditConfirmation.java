package app.servlets.bankProductServlet;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadClient;
import app.bankApp.DBtextformat.ReaderCredit;
import app.bankApp.DBtextformat.WriteCredit;
import app.entities.Credit;
import app.servlets.HtmlPage;
import app.servlets.include.NavBarServlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/bank_app/confirmCredit", asyncSupported =true)
public class CreditConfirmation extends HttpServlet {
    private WriteCredit wr = WriteCredit.getInstance();
    NavBarServlet navBar = new NavBarServlet();
    Bank bank = Bank.getInstance();
    Credit credit;
    int count = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        credit = (Credit) session.getAttribute("creditCalck");


        resp.getWriter().write(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);
        if (credit!=null){
            formConfirmCredit(resp);
        }else {
            resp.getWriter().append("<h4>Для вас нет подходящих предложений</h4>");
        }
        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("confirm")!=null){
            bank.getBankCollection().getCreditListOfBank().add(credit);
            wr.writeCredit(bank);
            session.removeAttribute("creditCalck");
            resp.sendRedirect("/bank_app/credit/main");
        }else if (req.getParameter("cancel")!=null){
            session.removeAttribute("creditCalck");
            resp.sendRedirect("/bank_app/credit/main");
        }

    }
    private void formConfirmCredit (HttpServletResponse resp) throws IOException {
        resp.getWriter().append("<form method=\"post\">\n" +
                "    <h4>Для вас подбран кредит</h4>\n" +
                "    <label> Название :</label> "+credit.getCreditName()+" <br/>\n" +
                "    <label> Сумма :</label> "+credit.getAmount()+"<br/>\n" +
                "    <label> Проценты :</label> "+credit.getPtc()+"<br/>\n" +
                "    <label> Срок :</label>"+credit.getCreditTerm()+ "<br/>\n" +
                "    <label> Платёж :</label> " +String.format("%.2f",credit.getPaymentMonth())+" <br/>\n" +
                "    <button name=\"confirm\" type=\"submit\">Подтвердить</button>\n" +
                "    <button name=\"cancel\" type=\"submit\">Отказаться</button>\n" +
                "\n" +
                "</form>");
    }
}
