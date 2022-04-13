package app.servlets.bankServiceServlet;

import app.entities.Account;
import app.entities.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

@WebServlet("/bank_app/payment/taransit")
public class TransitMoneyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Client client = (Client) session.getAttribute("client");
        if (client != null){
            Set<Account> accounts = client.getAccountListPersn();
            ArrayList<Account> accountList = new ArrayList<>(accounts);
            req.setAttribute("accounts", accountList);
            System.out.println(accounts);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/bankServiceViews/transitView.jsp");
        requestDispatcher.forward(req,resp);
    }
}
