package app.servlets.bankProductServlet;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReaderCredit;
import app.bankApp.FactoryProduct.CreditFactory.CreditFactory;
import app.entities.Client;
import app.entities.Credit;
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
import java.util.TreeSet;

@WebServlet(value = "/bank_app/credit/open",  asyncSupported = true)
public class CreditOpenServlet extends HttpServlet {
    NavBarServlet headerServlet = new NavBarServlet();
    private String textMsg = "";
    private String textSum = "";
    private String textTerm = "";
    private String textType = "";


    private ReaderCredit rc = ReaderCredit.getInstance();
    Bank bank = Bank.getInstance();
    CreditFactory creditFactory = new CreditFactory();
    private Client client;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        rc.readBD(bank);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write(HtmlPage.START.getHtmlElement());
        headerServlet.navbar(resp,req);
        formOpenCredit(resp);
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
                    && req.getParameter("type")!=null|| !req.getParameter("type").isEmpty()){
                HttpSession session = req.getSession();
                client = (Client) session.getAttribute("client" );
                if (client!= null){
                    Credit credit = creditFactory.createCredit(Bank.getInstance(),client,
                            Double.parseDouble(req.getParameter("sum")),
                            req.getParameter("type"),
                            Integer.parseInt(req.getParameter("term")));

                            session.setAttribute("creditCalck" , credit);

                    resp.sendRedirect("/bank_app/confirmCredit");

                }else {
                    textMsg = "Авторизуйтесь";
                    doGet(req,resp);

                }
            }else {
                doGet(req,resp);

            }

        }
        if (req.getParameter("cancel")!=null){resp.sendRedirect("/bank_app/credit/main");
        }
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
                "    <button name=\"calck\"  type=\"submit\">Рассчитать</button>\n" +
                "    <button name=\"cancel\" type=\"submit\">Назад</button>\n" +
                "</form>");}
}
