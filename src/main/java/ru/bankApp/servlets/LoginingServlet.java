package ru.bankApp.servlets;

import ru.bankApp.app.bankApp.Bank;
import ru.bankApp.app.bankApp.serviceBank.PasswordCheck;
import ru.bankApp.app.entities.Client;
import ru.bankApp.servlets.include.NavBarServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/bank_app/logining")
public class LoginingServlet extends HttpServlet {
    Bank bank = Bank.getInstance();
    NavBarServlet navBar = new NavBarServlet();
    PasswordCheck passwordCheck = new PasswordCheck();
    String phone;
    String password;
    String errorTextLogin = "";
    String errorTextPass= "";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().append(HtmlPage.START.htmlElement);
        navBar.navbar(resp,req);
        resp.getWriter().append("<p>Здравствуйте заполните форму</p>");
        formLogin(req,resp);
        resp.getWriter().append(HtmlPage.END.htmlElement);
    }
    /**
     * метод обрабатывает POST запросы
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        //получает значение с параметром "name"
        phone = req.getParameter("name");
        //получает значение с параметром "pass"
        password = req.getParameter("pass");
        //цикл который получает параметр кнопок из request
        if (req.getParameter("register")!= null){
            // отправляет клиента на страницу /register
            resp.sendRedirect("/bank_app/register" );
        }else if (req.getParameter("enter")!= null){
            if(phone.isEmpty()){
                errorTextLogin = "введите логин";
                doGet(req, resp);
            }else {
                errorTextLogin = "";
            }
            if (password.isEmpty()){
                errorTextPass = "введите пароль";
                doGet(req, resp);
            }else {
                errorTextPass = "";
            }
            if (!phone.isEmpty()&& !password.isEmpty()){
                Client client = passwordCheck.chekPassword(phone,password);
                if (client!=null){
                    HttpSession session = req.getSession();
                    session.setAttribute("client" , client);
                    resp.sendRedirect("/bank_app/main2");
                }else {
                    errorTextPass = "  неправильный пароль";
                    doGet(req, resp);
                }
            }
    }
      
     String al = req.getHeader("Accept-Language");
        System.out.println(al);
}
private void formLogin(HttpServletRequest req,HttpServletResponse resp) throws IOException {
    resp.getWriter().append(
            "<form method='post'>" +
                    "            <label>Name:<br />" +
                    "                <input type='text' name='name'>"+errorTextLogin +"<br />" +
                    "            </label>" +
                    "            <label>Password:<br />" +
                    "                <input type='password' name='pass'>"+errorTextPass +"<br />" +
                    "            </label>" +
                    "            <button  name='enter' type='submit'>Submit</button>" +
                    "            <button name='register' type='submit'>register</button> </form>"
    );}
}
