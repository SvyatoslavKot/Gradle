package ru.bankApp.servlets.employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/bank_app/admin/tasks")
public class TaskBidServlet extends HttpServlet {/*
    //BlockingQueueTask queue = BlockingQueueTask.getInstance();
    ServiceBidCreditCollection serviceBid = new ServiceBidCreditCollection();
    ServiceClientsCollection serviceClient = new ServiceClientsCollection();
    ServiceCreditCollection serviceCredit = new ServiceCreditCollection();

    ApplyCredit bidCredit;
    Client client ;
    Credit credit;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        bidCredit = (ApplyCredit) session.getAttribute("BidCreate");
        if (bidCredit != null){

            bidCredit.checkPaymentForSolvency();
            client = serviceClient.getClientByPhone(bidCredit.getClientPhone());
            credit = bidCredit.getCredit();
            formBid(req, resp);
            session.removeAttribute("BidCreate");
        }else {
            if (queue.getTasks().size()!=0){
                Task task = queue.getTask();
                bidCredit = serviceBid.getNum(task.getNum());
                bidCredit.checkPaymentForSolvency();
                client = serviceClient.getClientByPhone(bidCredit.getClientPhone());
                credit = bidCredit.getCredit();
                formBid(req, resp);
            }else {
                resp.getWriter().append("<h4>Заявок нет</h4>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(req.getParameter("approved")!=null){
           //serviceCredit.addCredit(credit);
           //serviceBid.removeBidCredit(bidCredit);
           bidCredit.setStatus(StatusBidCreditEnum.APPROVED.status);
           doGet(req,resp);
       }
       if (req.getParameter("rejected")!=null){
           bidCredit.setStatus(StatusBidCreditEnum.DENIED.status);
           doGet(req,resp);
       }
       if (req.getParameter("create")!=null){
           session.setAttribute("BidCreate" , bidCredit);
           resp.sendRedirect("/bank_app/admin/tasks/create");
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
                "Название кредита: " + credit.getCreditName() + "<br>" +
                "Сумма займа: " + credit.getAmount() + " рублей <br>" +
                "Срок займа: " + credit.getCreditTerm() + " месяцев <br>" +
                "Процентная ставка: " + credit.getPtc() + " % <br>" +
                "Платёж: " + String.format("%.2f",credit.getPaymentMonth()) + " рублей <br>" +
                "Доход клиента: " + bidCredit.getIncome() + " рублей <br>" +
                "Трудовой стаж: " + bidCredit.getExperience() + "<br>" +
                "Рек. макс. патёж: " + String.format("%.2f",bidCredit.getSolvency()) + " рублей <br>" +
                "Предварительный статус: " + bidCredit.getStatus() + "<br>" +
                "</p>" +
                "<button name = 'approved' type = 'submit'>Одобрено</button>" +
                "<button name = 'rejected' type = 'submit'>Отклонено</button>" +
                "<button name = 'create' type = 'submit'>Изменить</button>" +
                "</form>");
    }
    */
}
