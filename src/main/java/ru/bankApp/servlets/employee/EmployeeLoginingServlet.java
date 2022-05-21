package ru.bankApp.servlets.employee;

import ru.bankApp.app.bankApp.exeption.EmployNotNullEx;
import ru.bankApp.app.bankApp.exeption.EmployeePasswordEx;
import ru.bankApp.app.bankApp.serviceBank.PasswordCheck;
import ru.bankApp.app.entities.Employee;
import ru.bankApp.servlets.HtmlPage;
import ru.bankApp.servlets.include.NavBarServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/bank_app/employee")

public class EmployeeLoginingServlet extends HttpServlet {/*
    NavBarServlet navBar = new NavBarServlet();
    PasswordCheck passwordCheck = new PasswordCheck();
    private  String errorTextLogin = "";
    private  String errorTextPass = "";
    private String mainMsg = "";
    private  String phone;
    private String password;
    private String cookiesPhone;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        context.setAttribute("serviceEmployee", new ServiceEmployeeCollection());
        Cookie[] cookie = req.getCookies();
        for (Cookie c : cookie){
            if (c.getName().equals("CPhone")){
                cookiesPhone = c.getValue();
            }
        }

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);
        resp.getWriter().append("<p>Здравствуйте заполните форму</p>");
        formLogin(req,resp);
        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }
    /**
     * метод обрабатывает POST запросы
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    /*
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
            resp.sendRedirect("/bank_app/employee/reg" );
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
            Cookie cPhone = new Cookie("CPhone", phone);
            cPhone.setMaxAge(60);
            resp.addCookie(cPhone);
            if (!phone.isEmpty()&& phone!=null && password!=null&& !password.isEmpty()){
                try {
                    Employee employee = passwordCheck.checkPasswordEmployy(phone,password);
                    ServletContext context = req.getServletContext();
                    ServiceEmployeeCollection serviceEmployee = (ServiceEmployeeCollection) context.getAttribute("serviceEmployee");
                    serviceEmployee.putEmployee(employee);

                    Cookie user = new Cookie("employee", employee.getMobilePhone());
                    user.setMaxAge(1*30*24*60*60);
                    resp.addCookie(user);
                    resp.sendRedirect("/bank_app/employee/main");

                } catch (EmployeePasswordEx e) {
                    e.printStackTrace();
                    mainMsg = e.getMessage();
                    doGet(req,resp);
                } catch (EmployNotNullEx e) {
                    e.printStackTrace();
                    mainMsg = e.getMessage();
                }
                }
        }
    }
    private void formLogin(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        resp.getWriter().append(
                "<h5>"+mainMsg+"</h5><br>" +
                        "<form method='post'>" +
                        "            <label>Name:<br />" +
                        "                <input type='text' name='name'>"+errorTextLogin +"<br />" +
                        "            </label>" +
                        "            <label>Password:<br />" +
                        "                <input type='password' name='pass'>"+errorTextPass +"<br />" +
                        "            </label>" +
                        "            <button  name='enter' type='submit'>Submit</button>" +
                        "            <button name='register' type='submit'>register</button> </form>"
        );}*/
}
