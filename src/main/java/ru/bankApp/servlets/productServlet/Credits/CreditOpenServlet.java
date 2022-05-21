package ru.bankApp.servlets.productServlet.Credits;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(value = "/bank_app/credit/open",  asyncSupported = true)
public class CreditOpenServlet extends HttpServlet {/*
    NavBarServlet headerServlet = new NavBarServlet();
    ServiceBidCreditCollection serviceBid = new ServiceBidCreditCollection();
    private String textMsg = "";
    private String textSum = "";
    private String textTerm = "";
    private String textType = "";


  //  private ReaderCredit rc = ReaderCredit.getInstance();
    Bank bank = Bank.getInstance();
    ApplyCredit bidCredit;
    CreditFactory creditFactory = new CreditFactory();
    private Client client;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
      //  rc.readBD(bank);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write(HtmlPage.START.getHtmlElement());
        headerServlet.navbar(resp,req);
        if (req.getParameter("bidCredit")!= null){
            formResult(resp,req);
        }else {
            formOpenCredit(resp);
        }
        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        textMsg = "";
        if (req.getParameter("calck")!= null){
            if (req.getParameter("sum")== null || req.getParameter("sum").isEmpty()){
                textSum = "Введите желаемую ссуму!";
            }else {textSum = "";}
            if (req.getParameter("term").equals("0")){
                textTerm = "Выбирете срок!";
            }else {textTerm = "";}
            if (req.getParameter("type").equals("0")){
                textType = "Выбирете тип";
            }else{textType = "";}
            if (req.getParameter("sum")!= null ||!req.getParameter("sum").isEmpty()
                    && req.getParameter("term")!=null || !req.getParameter("term").isEmpty()
                    && req.getParameter("type")!=null|| !req.getParameter("type").isEmpty()
                    && req.getParameter("family")!=null|| !req.getParameter("family").isEmpty()
                    && req.getParameter("child")!=null|| !req.getParameter("child").isEmpty()
                    && req.getParameter("otherCredit")!=null|| !req.getParameter("otherCredit").isEmpty()
                    && req.getParameter("experience")!=null|| !req.getParameter("experience").isEmpty()
                    && req.getParameter("age")!=null|| !req.getParameter("age").isEmpty()
                     && req.getParameter("income")!=null|| !req.getParameter("income").isEmpty()){

                HttpSession session = req.getSession();
                client = (Client) session.getAttribute("client" );
                if (client!= null){
                   /* Credit credit = creditFactory.createCredit(Bank.getInstance(),client,
                            Double.parseDouble(req.getParameter("sum")),
                            req.getParameter("type"),
                            Integer.parseInt(req.getParameter("term")));

                    if (credit!= null){
                        boolean family = false;
                        if (req.getParameter("family").equals("0")){
                            family = false;
                        }if (req.getParameter("family").equals("1")){
                            family = true;
                        }
                        bidCredit = new BidCredit(StatusBidCreditEnum.PENDING.status, credit,client.getMobilePhone(),Integer.parseInt(req.getParameter("child")),
                                family, Integer.valueOf(req.getParameter("income")), Double.valueOf(req.getParameter("otherCredit")),
                                Integer.valueOf(req.getParameter("experience")),Integer.valueOf(req.getParameter("age")));
                        serviceBid.addBid(bidCredit);
                        BlockingQueueTask.getInstance().put(new Task(bidCredit.getNumBid()));

                        resp.sendRedirect("/bank_app/credit/open?bidCredit="+bidCredit.getNumBid()+"");

                    }
                            textMsg = "Нет подходящих предложений!";
                           doGet(req, resp);

                }else {
                    textMsg = "Авторизуйтесь";
                    doGet(req,resp);

                }
            }else {
                textMsg = "Заполните форму";
                doGet(req,resp);

           // }

       // }
        //if (req.getParameter("cancel")!=null){resp.sendRedirect("/bank_app/credit/main");
        }
    }
    private  void  formResult(HttpServletResponse resp, HttpServletRequest req) throws IOException {

        resp.getWriter().append("<p>Завка отправлена - "+req.getParameter("bidCredit")+"</p>");
    }
    private void formOpenCredit(HttpServletResponse resp) throws IOException {
        resp.getWriter().append("<h2>Форма для рассчета кредита</h2>\n" +
                "<h5>"+textMsg+"</h5>" +
                "<form method=\"post\">\n" +
                "    <label>Сумма:<br />\n" +
                "        <input type=\"text\" name=\"sum\"><br />\n" +
                "    </label>\n" + textSum +
                "    <br />\n" +
                "    <label>Тип:<br />\n" +
                "        <select name=\"type\" >\n" + textType +
                "            <option value=\"0\"></option>\n" +
                "            <option value=\"CREDITCARD\">Кредитная</option>\n" +
                "            <option value=\"CONSUMER\">Потребительский</option>\n" +
                "            <option value=\"AVTO\">Автокредит</option>\n" +
                "            <option value=\"HYPOTHEC\">Ипотека</option>\n" +
                "        </select>\n" +
                "    </label><br />\n" +
                "    <br />\n" +
                "    <label>Срок кредита:<br />\n" +
                "        <select name=\"term\" >\n" +textTerm+
                "            <option value=\"0\"></option>\n" +
                "            <option value=\"3\">3</option>\n" +
                "            <option value=\"6\">6</option>\n" +
                "            <option value=\"12\">12</option>\n" +
                "            <option value=\"18\">18</option>\n" +
                "            <option value=\"24\">24</option>\n" +
                "            <option value=\"36\">36</option>\n" +
                "            <option value=\"60\">60</option>\n" +
                "            <option value=\"120\">120</option>\n" +
                "            <option value=\"240\">240</option>\n" +
                "            <option value=\"360\">360</option>\n" +
                "        </select>\n" +
                "    </label><br />\n" +
                "    <br />\n" +
                "    <label>Семейное положение:<br />\n" +
                "        <select name=\"family\" >\n" + //textType +
                "            <option value=\"\"></option>\n" +
                "            <option value=\"0\">нет</option>\n" +
                "            <option value=\"1\">женат(замужем)</option>\n" +
                "        </select>\n" +
                "    </label><br />\n" +
                "    <label>Доход:<br />\n" +
                "        <input type=\"text\" name=\"income\"><br />\n" +
                "    </label>\n" + //textSum +
                "    <label>Дети:<br />\n" +
                "        <select name=\"child\" >\n" + //textType +
                "            <option value=\"0\">нет</option>\n" +
                "            <option value=\"1\">1</option>\n" +
                "            <option value=\"2\">2</option>\n" +
                "            <option value=\"3\">3</option>\n" +
                "            <option value=\"4\">4 и больше</option>\n" +
                "        </select>\n" +
                "    </label><br />\n" +
                "    <label>Другие кредиты:<br />\n" +
                "        <input type=\"text\" name=\"otherCredit\"><br />\n" +
                "    </label>\n" + //textSum +
                "    <label>Стаж:<br />\n" +
                "        <select name=\"experience\" >\n" + //textType +
                "            <option value=\"0\">0</option>\n" +
                "            <option value=\"1\">1</option>\n" +
                "            <option value=\"2\">2</option>\n" +
                "            <option value=\"3\">3</option>\n" +
                "            <option value=\"4\">4 и больше</option>\n" +
                "        </select>\n" +
                "    </label><br />\n" +
                "    <label>Возраст:<br />\n" +
                "        <input type=\"text\" name=\"age\"><br />\n" +
                "    </label>\n" +
                "    <button name=\"calck\"  type=\"submit\">Рассчитать</button>\n" +
                "    <button name=\"cancel\" type=\"submit\">Назад</button>\n" +
                "</form>");}
        */
}
