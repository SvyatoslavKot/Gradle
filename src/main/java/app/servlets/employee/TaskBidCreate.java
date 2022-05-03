package app.servlets.employee;

import app.bankApp.bankCollection.ServiceClientsCollection;
import app.bankApp.serviceBank.CreditCalculationPayment;
import app.entities.BidCredit;
import app.entities.Client;
import app.entities.Credit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/bank_app/admin/tasks/create")
public class TaskBidCreate extends HttpServlet {
    BidCredit bidCredit;
    Client client;
    Credit credit;
    ServiceClientsCollection serviceClient = new ServiceClientsCollection();
    CreditCalculationPayment creditPayment = new CreditCalculationPayment();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();
        bidCredit = (BidCredit) session.getAttribute("BidCreate");
        if (bidCredit!=null){
            client = serviceClient.getClientByPhone(bidCredit.getClientPhone());
            credit = bidCredit.getCredit();
            formBid(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("cancel")!=null){
            resp.sendRedirect("/bank_app/admin/tasks");
        }
        if (req.getParameter("create")!=null){
            if (req.getParameter("name")!=null&& !req.getParameter("name").isEmpty()){
                credit.setCreditName(req.getParameter("name"));
            }
            if (req.getParameter("amount")!=null&& !req.getParameter("amount").isEmpty()){
                credit.setAmount(Double.valueOf(req.getParameter("amount")));
            }
            if (req.getParameter("term")!=null&& !req.getParameter("term").isEmpty()){
                credit.setCreditTerm(Integer.valueOf(req.getParameter("term")));
            }
            if (req.getParameter("ptc")!=null&& !req.getParameter("ptc").isEmpty()){
                credit.setPtc(Double.valueOf(req.getParameter("ptc")));
            }
            credit.setPaymentMonth(creditPayment.calc(credit.getAmount(), credit.getPtc(), credit.getCreditTerm()));
            bidCredit.setCredit(credit);
            resp.sendRedirect("/bank_app/admin/tasks");
        }
    }

    public void formBid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().append("" +
                "<form method='post'>" +
                "<p>" +
                "Номер заявки: " + bidCredit.getNumBid() + "<br>" +
                "Имя клиента: " + client.getUserName() + "<br>" +
                "Фамилия клиента: " + client.getLastName() + "<br>" +
                "Возраст клиента: " + bidCredit.getAge() + "<br>" +
                "Дети: " + bidCredit.getChild() + "<br>" +
                "Название кредита: " + credit.getCreditName() + " <input type=\"text\" name=\"name\"><br>" +
                "Сумма займа: " + credit.getAmount() + " рублей  <input type=\"text\" name=\"amount\"><br>" +
                "Срок займа: " + credit.getCreditTerm() + " месяцев  <input type=\"text\" name=\"term\"><br>" +
                "Процентная ставка: " + credit.getPtc() + " %  <input type=\"text\" name=\"ptc\"><br>" +
                "Доход клиента: " + bidCredit.getIncome() + " рублей <br>" +
                "Трудовой стаж: " + bidCredit.getExperience() + "<br>" +
                "Рек. макс. патёж: " + bidCredit.getSolvency() + " рублей <br>" +
                "Предварительный статус: " + bidCredit.getStatus() + "<br>" +
                "</p>" +
                "<button name = 'cancel' type = 'submit'>Назад</button>" +
                "<button name = 'create' type = 'submit'>Изменить</button>" +
                "</form>");
    }
}
