package app.servlets;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadClient;
import app.bankApp.DBtextformat.WriteClient;
import app.bankApp.bankCollection.ServiceClientsCollection;
import app.bankApp.exeption.ClientAddExeption;
import app.entities.Client;
import app.servlets.include.NavBarServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.swing.*;
import java.io.IOException;

/**
 * @author SvyatoslavK
 * Servlet страницы регистрации профиля клиента
 * Mapping прописан в @WebServlet
 * */
@WebServlet("/bank_app/register")
public class RegisterServlet extends HttpServlet {

    Client client ;
    Bank bank = Bank.getInstance();
    ReadClient readClient = ReadClient.getInstance();
    WriteClient writeClient = WriteClient.getInstance();
    NavBarServlet navBar = new NavBarServlet();
    ServiceClientsCollection serviceClient = new ServiceClientsCollection();

    private String errorName = "";
    private String errorLastName = "";
    private String errorNickName ="";
    private String errorPassword = "";
    private  String formMessage = "";


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        readClient.readBD(bank);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().append(HtmlPage.START.htmlElement);
        navBar.navbar(resp,req);
        registerForm(req,resp);

        resp.getWriter().append(HtmlPage.END.htmlElement);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
         String lastName = req.getParameter("lastName");
         String id = String.valueOf(bank.getBankCollection().getClientHashMap().size() + 1);
         String nickName = req.getParameter("nickName");;
         String password1 = req.getParameter("password1");
         String password2 = req.getParameter("password2");
        if (req.getParameter("enter") !=null) {
            if (userName.isEmpty() || userName== null){
                errorName = "Введите имя";
            }else {errorName = "";}
            if (lastName.isEmpty() || lastName== null){
                errorLastName = "Введите Фамилию";
            }else {errorLastName = "";}
            if (nickName.isEmpty() || nickName== null){
                errorNickName = "Введите логин";
            }else {errorNickName = "";}
            if (password1.isEmpty() || password1== null || password2.isEmpty() || password2== null){
                errorPassword = "Введите пароль пароль";
            }else {errorPassword = "";}

            if (userName!= null && !userName.isEmpty() && lastName != null && !lastName.isEmpty() &&
             nickName !=null && !nickName.isEmpty() && password1 != null && !password1.isEmpty() &&
            password2 != null && !password2.isEmpty()){
                if (password1.equals(password2)){
                    client = new Client(userName,lastName,id,nickName,password1);
                    try {
                        serviceClient.addClient(client);
                        HttpSession session = req.getSession();
                        resp.sendRedirect("/bank_app/main2");
                        writeClient.writeClient(bank);
                        session.setAttribute("client", client);
                    } catch (ClientAddExeption e) {
                        formMessage = e.getMessage();
                        e.printStackTrace();
                        doGet(req,resp);
                    }
                }else {
                    errorPassword = "неверный пароль";
                    doGet(req,resp);

                }
            }
            else{
                doGet(req,resp);
            }
        }
    }


    private void registerForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
         String valueName = "";
         String valueLastName = "";
        String valueNickName ="";
        if (req.getParameter("name")!= null&& !req.getParameter("name").isEmpty()){
            valueName = req.getParameter("name");
        }
        if (req.getParameter("lastName")!= null&& !req.getParameter("lastName").isEmpty()){
            valueLastName = req.getParameter("lastName");
        }
        if (req.getParameter("nickName")!= null&& !req.getParameter("nickName").isEmpty()){
            valueNickName = req.getParameter("nickName");
        }
        resp.getWriter().append("<div>\n" +
                "        <h3>Регистрация</h3><br>\n" +
                "<h5>"+formMessage+"</h5>" +
                "    </div>\n" +
                "    <div >\n" +
                "        <form method=\"post\">\n" +
                "            <label>Name:<br />\n" +
                "                <input type=\"text\"\n" +
                "                       name=\"name\"\n" +
                "                       value=\""+valueName+"\">\n" +errorName+ "<br />\n" +
                "            </label>\n" +
                "            <label>Last Name:<br />\n" +
                "                <input type=\"text\"\n" +
                "                       name=\"lastName\"\n" +
                "                       value=\""+valueLastName+"\">\n" +errorLastName+"<br />\n" +
                "            </label>\n" +
                "            <label>Nickname:<br />\n" +
                "                <input type=\"text\" name=\"nickName\"\n" +
                "                       value=\""+valueNickName+"\">\n" +errorNickName+"<br />\n" +
                "            </label>\n" +
                "            <label>Password:<br />\n" +
                "                <input type=\"password\" name=\"password1\">\n" + "<br />\n" +
                "                <input type=\"password\" name=\"password2\">\n" +errorPassword+"<br />\n" +
                "        </label>\n"+
                "            <button name=\"enter\"  type=\"submit\">Register</button>\n" +
                "            <button name=\"register\" type=\"submit\">Cancel</button>\n" +
                "\n" +
                "        </form>\n" +
                "\n" +
                "        </form>\n" +
                "    </div>");
    }
}
