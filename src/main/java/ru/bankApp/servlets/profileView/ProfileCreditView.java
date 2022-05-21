package ru.bankApp.servlets.profileView;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/bank_app/profile/credit")
public class ProfileCreditView extends HttpServlet {/*
    NavBarServlet navBar = new NavBarServlet();

    ServiceCreditCollection seviceCredit = new ServiceCreditCollection();
    ServiceBidCreditCollection serviceBid = new ServiceBidCreditCollection();
    //ReaderCredit rc = ReaderCredit.getInstance();
   // WriteCredit wr = WriteCredit.getInstance();

    Client client;
    Bank bank = Bank.getInstance();
    SortCreditList sortCreditList = new SortCreditList();
    ArrayList<Credit> credits;
    ArrayList<ApplyCredit> bidCredits;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
      //  rc.readBD(bank);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();

        if (req.getParameter("bidCreditRemove")!=null){
            ApplyCredit bidCreditRemove = serviceBid.getNum(Integer.valueOf(req.getParameter("bidCreditRemove")));
            serviceBid.removeBidCredit(bidCreditRemove);
        }
        if (req.getParameter("bidCreditAdd")!=null){
            ApplyCredit bidCreditAdd = serviceBid.getNum(Integer.valueOf(req.getParameter("bidCreditAdd")));
            seviceCredit.addCredit(bidCreditAdd.getCredit());
            serviceBid.removeBidCredit(bidCreditAdd);
          //  wr.writeCredit(Bank.getInstance());
        }
        client = (Client) session.getAttribute("client");
        credits = seviceCredit.getAccountByClient(client);
        bidCredits = serviceBid.getBiClient(client);


        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);
        sortMenu(req, resp);

        if (req.getParameter("sortButton")!= null){
            if (req.getParameter("sortParam").equals("1")){
                credits = (ArrayList<Credit>) sortCreditList.sortByAmountLow(credits);
            }else if (req.getParameter("sortParam").equals("2")) {
                credits = (ArrayList<Credit>) sortCreditList.sortByAmountHight(credits);
            }else if (req.getParameter("sortParam").equals("3")) {
                credits = (ArrayList<Credit>) sortCreditList.sortByName(credits);
            }else if (req.getParameter("sortParam").equals("4")) {
                credits = (ArrayList<Credit>) sortCreditList.sortByDate(credits);
            }
        }else {
            credits = (ArrayList<Credit>) sortCreditList.sortByDate(credits);
        }

        creditTable(req,resp);

        if (bidCredits.size()!=0){
            creditBidTable(req, resp);
        }
        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }

    private void sortMenu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().append("<div>\n" +
                "    <form method=\"get\">\n" +
                "        <label>Сортировать</label>\n" +
                "        <select name= \"sortParam\">\n" +
                "            <option value=\"4\">по дате</option>\n" +
                "            <option value=\"1\">возрастанию задолжности</option>\n" +
                "            <option value= \"2\">уменьшению задолжности</option>\n" +
                "            <option value=\"3\">по названию</option>\n" +
                "        </select>\n" +
                "        <button name=\"sortButton\" type=\"submit\">Cортировать</button>\n" +
                "    </form>\n" +
                "</div>");
    }

    private void creditTable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().append(
                "<h5>Кредиты</h5>"+
                        "        <table border='1'>"+
                        "                <tr>\n" +
                        "                    <td width=\"150\">Названиеи</td>\n" +
                        "                    <td width=\"150\">Номер счета</td>\n" +
                        "                    <td width=\"150\">Задолженность</td>\n" +
                        "                    <td width=\"150\">Проценты</td>\n" +
                        "                    <td width=\"150\">Дата открытия</td>\n" +
                        "                    <td width=\"150\">Срок погашения</td>\n" +
                        "                    <td width=\"150\">Платёж</td>\n" +
                        "                </tr>\n");
        for (Credit credit : credits){
            resp.getWriter().append("                <tr>\n" +
                            "                    <td width=\"150\">"+credit.getCreditName()+"</td>\n" +
                            "                    <td width=\"150\">"+credit.getAccountNumber()+"</td>\n" +
                            "                    <td width=\"150\">"+credit.getAmount()+"</td>\n" +
                            "                    <td width=\"150\">"+credit.getPtc()+"</td>\n" +
                            "                    <td width=\"150\">"+credit.getOpeningDate()+"</td>\n" +
                            "                    <td width=\"150\">"+credit.getCreditTerm()+"</td>\n" +
                            "                    <td width=\"150\"><a href=''>" +String.format("%.2f", credit.getPaymentMonth())+"</a></td>\n"+
                            "                </tr>\n");
        }
        resp.getWriter().append("        </table>");
    }
    private void creditBidTable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().append("<h4>Заявки</h4>" +
                        "        <table border='1'>"+
                        "                <tr>\n" +
                        "                    <td width=\"150\">Номер Заявки</td>\n" +
                        "                    <td width=\"150\">Название кредита</td>\n" +
                        "                    <td width=\"150\">Сумма кредита</td>\n" +
                        "                    <td width=\"150\">Проценты</td>\n" +
                        "                    <td width=\"150\">Срок Кредита</td>\n" +
                        "                    <td width=\"150\">Платёж</td>\n" +
                        "                    <td width=\"150\">Статус</td>\n" +
                        "                </tr>\n");
        for (ApplyCredit bidCredit : bidCredits) {
            resp.getWriter().append("                <tr>\n" +
                            "                    <td width=\"150\">" + bidCredit.getNumBid() + "</td>\n" +
                            "                    <td width=\"150\">" + bidCredit.getCredit().getCreditName() + "</td>\n" +
                            "                    <td width=\"150\">" + bidCredit.getCredit().getAmount() + "</td>\n" +
                            "                    <td width=\"150\">" + bidCredit.getCredit().getPtc() + "</td>\n" +
                            "                    <td width=\"150\">" + bidCredit.getCredit().getCreditTerm() + "</td>\n" +
                            "                    <td width=\"150\">" + String.format("%.2f",bidCredit.getCredit().getPaymentMonth()) + "</td>\n" +
                            "                    <td width=\"150\">" + bidCredit.getStatus() + "</td>\n");

            if(bidCredit.getStatus().equals(StatusBidCreditEnum.DENIED.status)){
                 resp.getWriter().append("<td><button onclick=\"location.href=\'/bank_app/profile/credit?bidCreditRemove" +bidCredit.getNumBid()+ "\'\">OK</button></td>");}
                     if (bidCredit.getStatus().equals(StatusBidCreditEnum.APPROVED.status)){
                         resp.getWriter().append(
                              "<td><button onclick=\"location.href='/bank_app/profile/credit?bidCreditRemove="+bidCredit.getNumBid()+"'\">отказаться</button></td>" +
                              "<td><button onclick=\"location.href='/bank_app/profile/credit?bidCreditAdd="+bidCredit.getNumBid()+"'\">подтвердить</button></td>");}

                     resp.getWriter().append("</tr> </table>");
        }
    }*/
}
