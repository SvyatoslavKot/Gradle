package app.servlets.include;

import app.bankApp.Bank;
import app.entities.Client;
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

                "<button name=\"enter\"  type=\"submit\">ГЛАВНАЯ</button> "+
                " <button onclick="+"location.href='/bank_app/credit/main'"+">Кредиты</button>"+
                " <button onclick="+"location.href='/bank_app/account/main'"+">Кредиты</button>"+
                " <button onclick="+"location.href='/bank_app/main/payment'"+">Кредиты</button>");

        if (client!= null){
            resp.getWriter().append("<button onclick=location.href='/bank_app/profileview'>"+ client.getNickName() +"</button></nav> <br>" );
        }else if (client==null){
            resp.getWriter().append("<button onclick=location.href='/bank_app/logining'>Войти </button> </nav> <br>");
            }
    }

}
