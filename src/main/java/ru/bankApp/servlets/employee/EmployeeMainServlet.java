package ru.bankApp.servlets.employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/**
 * this servlet Admin window
 * show information about the number of client and products
 */
@WebServlet("/bank_app/employee/main")
public class EmployeeMainServlet extends HttpServlet {/*
    Bank bank = Bank.getInstance();

    NavBarEmployeeServlet navBar = new NavBarEmployeeServlet();

    ServiceCreditCollection serisCredit = new ServiceCreditCollection();
    ServiceAccountCollection servisAccount = new ServiceAccountCollection();
    ServiceClientsCollection serviceClient = new ServiceClientsCollection();
    ServiceBidCreditCollection serviceBid = new ServiceBidCreditCollection();
    ServiceEmployeeCollection serviceEmployee = new ServiceEmployeeCollection();
    Employee employee;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        ArrayList<Client> clients = serviceClient.getAllClients();
        ArrayList<Credit> credits = serisCredit.getAllCredits();
        ArrayList<Account> accounts = servisAccount.getAllAccounts();
        ArrayList<ApplyCredit> bidCredits = serviceBid.getAllBids();

        navBar.navbar(resp,req);
        resp.getWriter().append("<br><h4>Окно администратора</h4><br>"+
                "<button onclick=\"location.href='/bank_app/admin/tasks'\">Перейти к работе с заявками</button>" +
                "<p>Выберите список: </p>"+
                "<div>\n" +
                "    <form method=\"get\">\n" +
                "        <label>Сортировать</label>\n" +
                "        <select name= \"list\">\n" +
                "               <option disabled>Выберите</option>"+
                "            <option value=\"1\">Клиенты</option>\n" +
                "            <option value=\"2\">Кредиты</option>\n" +
                "            <option value= \"3\">Счета</option>\n" +
                "            <option value= \"4\">headers</option>\n" +
                "            <option value= \"5\">Заявки на кредит</option>\n" +
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
                        "                    <td width=\"100\">Телефон</td>\n" +
                        "                    <td width=\"100\">Id</td>\n" +
                        "                    <td width=\"100\">Пароль</td>\n" +
                        "                </tr>\n" +
                        "           \n");
            for (Client c : clients){
                    resp.getWriter().append(
                                    "        <table border='1'>"+
                                    "                <tr>\n" +
                                    "                    <td width=\"100\">"+c.getUserName()+"</td>\n" +
                                    "                    <td width=\"100\">"+c.getLastName()+"</td>\n" +
                                    "                    <td width=\"100\">"+c.getNickName()+"</td>\n" +
                                    "                    <td width=\"100\">"+c.getMobilePhone()+"</td>\n" +
                                    "                    <td width=\"100\">"+c.getId()+"</td>\n" +
                                    "                    <td width=\"100\">"+c.getPassword()+"</td>\n" +
                                    "                </tr>\n" +
                                    "           \n");

                }
            resp.getWriter().append("</table>");
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
                            "                    <td width=\"150\">Тел. держателя</td>\n" +
                            "                </tr>\n" +
                            "           \n");
            for (Credit credit : credits){
                resp.getWriter().append(
                        "        <table border='1'>"+
                                "                <tr>\n" +
                                "                    <td width=\"150\">"+credit.getCreditName()+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getAccountNumber()+"</td>\n" +
                                "                    <td width=\"150\">"+String.format("%.2f",credit.getAmount())+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getPtc()+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getOpeningDate()+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getCreditTerm()+"</td>\n" +
                                "                    <td width=\"150\">" +String.format("%.2f",credit.getPaymentMonth())+"</td>\n" +
                                "                    <td width=\"150\">"+credit.getPhoneHolder()+"</td>\n" +

                                "                </tr>\n" +
                                "           \n");

            }
            resp.getWriter().append("</table>");
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
                            "                    <td width=\"150\">login holder</td>\n" +
                            "                    <td width=\"150\">pin</td>\n" +
                            "                </tr>\n" +
                            "           \n");
            for (Account account : accounts){
                resp.getWriter().append(
                        "        <table border='1'>"+
                                "                <tr>\n" +
                                "                    <td width=\"180\">"+account.getName()+"</td>\n" +
                                "                    <td width=\"150\">"+account.getAccount_num()+"</td>\n" +
                                "                    <td width=\"150\">" +String.format("%.2f",account.getMoney_in_account())+"</td>\n" +
                                "                    <td width=\"150\">"+account.getCredit_term()+"</td>\n" +
                                "                    <td width=\"150\">"+account.getPayment()+"</td>\n" +
                                "                    <td width=\"150\">"+account.getCashBack()+"</td>\n" +

                                "                </tr>\n" +
                                "           \n");

            }
            resp.getWriter().append("</table>");
        }
        if (req.getParameter("list").equals("4")){
            Enumeration<String> headers = req.getHeaderNames();
            int n = 0;
            resp.getWriter().append(
                    "<h5>headers</h5>"+
                            "        <table border='1'>"+
                            "                <tr>\n" +
                            "                    <td width=\"15\">№ </td>\n" +
                            "                    <td width=\"150\">Header Name</td>\n" +
                            "                    <td width=\"800\">Headers</td>\n" +
                            "                </tr>\n" +
                            "           \n");
           while (headers.hasMoreElements()){
               String s = headers.nextElement();
               n++;
               resp.getWriter().append(
                        "        <table border='1'>"+
                                "                <tr>\n" +
                                "                    <td width=\"15\">"+n+"</td>\n" +
                                "                    <td width=\"150\">"+s+"</td>\n" +
                                "                    <td width=\"800\">"+req.getHeader(s)+"</td>\n" +
                                "                </tr>\n" +
                                "           \n");

            }
            resp.getWriter().append("</table>");
        }
        if (req.getParameter("list").equals("5")){
            resp.getWriter().append(
                    "<h5>Заявки</h5>"+
                            "        <table border='1'>"+
                            "                <tr>\n" +
                            "                    <td width=\"25\">№ </td>\n" +
                            "                    <td width=\"150\">Название</td>\n" +
                            "                    <td width=\"150\">Клиент</td>\n" +
                            "                    <td width=\"800\">Статус заявки</td>\n" +
                            "                </tr>\n" +
                            "           \n");
            for (ApplyCredit bidCredit : bidCredits){
                resp.getWriter().append(
                        "        <table border='1'>"+
                                "                <tr>\n" +
                                "                    <td width=\"25\">"+bidCredit.getNumBid()+"</td>\n" +
                                "                    <td width=\"150\">"+bidCredit.getCredit().getCreditName()+"</td>\n" +
                                "                    <td width=\"150\">"+bidCredit.getClientPhone()+"</td>\n" +
                                "                    <td width=\"800\">"+bidCredit.getStatus()+"</td>\n" +
                                "                </tr>\n" +
                                "           \n");

            }
            resp.getWriter().append("</table>");
        }
    }*/
}
