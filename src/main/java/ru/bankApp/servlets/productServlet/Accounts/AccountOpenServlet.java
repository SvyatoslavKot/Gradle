package ru.bankApp.servlets.productServlet.Accounts;

import ru.bankApp.app.bankApp.Bank;
import ru.bankApp.app.entities.accountFactory.AccountFactory;
import ru.bankApp.app.entities.Client;
import ru.bankApp.servlets.HtmlPage;
import ru.bankApp.servlets.include.NavBarServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bank_app/account/open")
public class AccountOpenServlet extends HttpServlet {
    NavBarServlet headerServlet = new NavBarServlet();
    private  String textMsg = "";
    private  String textlevel = "";
    private  String textTerm = "";
    private  String textType = "";

    Client client;
    Bank bank = Bank.getInstance();
    AccountFactory af = new AccountFactory();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write(HtmlPage.START.getHtmlElement());
        headerServlet.navbar(resp,req);
        resp.getWriter().append("<h4>Форма оформления кредита</h4><br>");
        resp.getWriter().append(textMsg);
        openCreditForm(resp);
        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* if (req.getParameter("enter")!=null){
            System.out.println(req.getParameter("level") +" "+ req.getParameter("term") +" "+req.getParameter("type"));
            if (req.getParameter("level").equals("0")){
            textlevel = "Выбирете уровень!";
        }else {textlevel = "";}
        if (req.getParameter("term").equals("0")){
            textTerm = "Выбирете срок обслуживания!";
        }else {textTerm = "";}
        if (req.getParameter("type").equals("0")){
            textType = "Выбирете тип счета!";
        }else {textType = "";}


      if (!req.getParameter("level").equals("0") && !req.getParameter("term").equals("0") && !req.getParameter("type").equals("0")){
                HttpSession session = req.getSession();
                client = (Client) session.getAttribute("client" );
                if (client!= null){
                    String level = req.getParameter("level");
                    int term = Integer.parseInt(req.getParameter("term"));
                    String type = req.getParameter("type");

                    Account account = af.createAccount(bank,client,type,term, "000", level);
                        System.out.println(account);
                    session.setAttribute("accountCalk" , account);
                    resp.sendRedirect("/bank_app/account/confirm_account");
                }else {
                    textMsg = "Авторизутесь!";
                    //doGet(req,resp);
                }
                }else {
                //doGet(req,resp);
                }
            doGet(req,resp);
        }
        if (req.getParameter("cancel") != null){
            resp.sendRedirect("/bank_app/account/main");
        }*/
    }

    private void openCreditForm(HttpServletResponse resp) throws IOException {
        resp.getWriter().append("<form method=\"post\">\n" +
                "<label>Срок(мес)<br />\n" +
                "    <select name=\"term\">\n"+
                "        <option value=\"0\"></option>\n" +
                "        <option value=\"6\">6</option>\n" +
                "        <option value=\"12\">12</option>\n" +
                "        <option value=\"24\">24</option>\n" +
                "        <option value=\"36\">36</option>\n" +
                "    </select>\n" + textTerm+
                "</label><br />\n" +
                "<label>Тип<br />\n" +
                "    <select name=\"type\">\n" +
                "        <option value=\"0\"></option>\n" +
                "        <option value=\"STANDARD\">Стандартный</option>\n" +
                "        <option value=\"CURRENCY\">Валютный</option>\n" +
                "        <option value=\"PREMIUM\">Премиальный</option>\n" +
                "        <option value=\"TRAVEL\">Туристический</option>\n" +
                "    </select>\n" +textType+
                "</label><br />\n" +
                "<label>Уровень<br />\n" +
                "    <select name=\"level\">\n" +
                "        <option value=\"0\"></option>\n" +
                "        <option value=\"LIGHT\">light</option>\n" +
                "        <option value=\"STANDARD\">standard</option>\n" +
                "        <option value=\"GOLD\">gold</option>\n" +
                "\n" +
                "    </select>\n" +textlevel+
                "</label><br />\n" +
                "    <br/>\n" +
                "    <button name=\"cancel\" type=\"submit\">Назад</button>\n" +
                "    <button name=\"enter\"  type=\"submit\">Рассчитать</button>\n" +
                "\n" +
                "</form>");
    }
}
