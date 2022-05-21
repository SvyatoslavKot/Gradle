package ru.bankApp.servlets.include;

import ru.bankApp.app.bankApp.Bank;
import ru.bankApp.app.entities.Client;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class NavBarServlet extends HttpServlet {
    Bank bank = Bank.getInstance();

        public  void navbar(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        HttpSession session = req.getSession();
            Client client = (Client) session.getAttribute("client");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().append("<nav>"+bank.getName()  +

                "<button onclick="+"location.href='/bank_app/main2'"+">ГЛАВНАЯ</button> "+
                " <button onclick="+"location.href='/bank_app/credit/main'"+">Кредиты</button>"+
                " <button onclick="+"location.href='/bank_app/account/main'"+">Счета</button>"+
                " <button onclick="+"location.href='/bank_app/main/payment'"+">Платежи</button>");

        if (client!= null){
            resp.getWriter().append("<button onclick=location.href='/bank_app/profileview'>"+ client.getUserName() +"</button></nav> <br>" );
        }else if (client==null){
            resp.getWriter().append("<button onclick=location.href='/bank_app/logining'>Войти </button> </nav> <br>");
            }
    }

}
