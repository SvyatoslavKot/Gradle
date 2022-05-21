package ru.bankApp.servlets.include;

import ru.bankApp.app.bankApp.Bank;
import ru.bankApp.app.entities.Employee;
import jakarta.servlet.http.*;

import java.io.IOException;

public class NavBarEmployeeServlet extends HttpServlet {/*
    Bank bank = Bank.getInstance();
    ServiceEmployeeCollection serviceEmployeeCollection = new ServiceEmployeeCollection();
    Employee employee;

    public  void navbar(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies){
            if (c.getName().equals("employee")){
                employee = serviceEmployeeCollection.getEmployeeByPhone(c.getValue());
            }
        }

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().append("<nav>"+bank.getName()  +

                "<button onclick="+"location.href='/bank_app/main2'"+">ГЛАВНАЯ</button> "+
                " <button onclick="+"location.href='/bank_app/credit/main'"+">Кредиты</button>"+
                " <button onclick="+"location.href='/bank_app/account/main'"+">Счета</button>"+
                " <button onclick="+"location.href='/bank_app/main/payment'"+">Платежи</button>");

        if (employee!= null){
            resp.getWriter().append("<button onclick=location.href='/bank_app/employee/profile'>"+ employee.getMobilePhone() +"</button></nav> <br>" );
        }else if (employee==null){
            resp.getWriter().append("<button onclick=location.href='/bank_app/logining'>Войти </button> </nav> <br>");
        }
    }*/
}
