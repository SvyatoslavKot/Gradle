package app.servlets.employee;

import app.bankApp.bankCollection.ServiceEmployeeCollection;
import app.entities.Employee;
import app.servlets.HtmlPage;
import app.servlets.include.NavBarEmployeeServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpClient;
@WebServlet("/bank_app/employee/profile")
public class EmployeeProfileServlet extends HttpServlet {
    Employee employee;
    NavBarEmployeeServlet navBar = new NavBarEmployeeServlet();
    ServiceEmployeeCollection serviceEmployee = new ServiceEmployeeCollection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies){
            if (c.getName().equals("employee")){
                employee = serviceEmployee.getEmployeeByPhone(c.getValue());
            }
        }

        resp.getWriter().append(HtmlPage.START.getHtmlElement());
        navBar.navbar(resp,req);
        if (employee!=null){
            formProfile(req,resp);
        }else resp.getWriter().append("<h4>Авторизуйтесь</h4>");

        resp.getWriter().append(HtmlPage.END.getHtmlElement());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("exit")!=null){
            Cookie[] cookies = req.getCookies();
            for (Cookie c : cookies){
                if (c.getName().equals("employee")){
                    c.setMaxAge(0);
                    resp.addCookie(c);
                    resp.sendRedirect("/bank_app/employee/main");
                }
            }
        }
    }

    private  void formProfile(HttpServletRequest req , HttpServletResponse resp ) throws IOException {
        resp.getWriter().append("" +
                "<h4>Окно профиля работника</h4> <a href = '/bank_app/main2'>изменить</a> <br>" +
                "<label>Имя:<br />" + employee.getUserName() +"</label><br>" +
                "<label>Фамилия:<br />" + employee.getLastName() +"</label><br>" +
                "<label>Логин:<br />" + employee.getNickName() +"</label><br>" +
                "<label>Должность:<br />" + employee.getPosition() +"</label><br>" +
                "<label>Возраст:<br />" + employee.getAge() +"</label><br>" +
                "<label>Номер телефона:<br />" + employee.getMobilePhone() +"</label><br>" +
                "</div>" +
                "<br/>\n" +
                "            <button onclick=location.href='/bank_app/profile/credit' >Заявки на кредит</button><br/>\n" +
                "        <br/>\n" +
                "            <button onclick=location.href='/bank_app/profile/accounts'>Заявки на счета</button><br/>\n" +
                "        <br/>\n" +
                "            <button onclick=location.href='/bank_app/profileview'>Смотреть списки</button><br/>\n" +
                "        <br/>\n" +
                "        <form method=\"post\">\n" +
                "            <button name=\"exit\" type=\"submit\">Выйти</button>\n" +
                "        </form>\n" +
                "    </div>");

    }
}
