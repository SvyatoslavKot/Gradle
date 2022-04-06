package app.servlets;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadClient;
import app.entities.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    Bank bank = Bank.getInstance();
    ReadClient readClient = ReadClient.getInstance();
    HashMap<String, Client> clientList = bank.getBankCollection().getClientHashMap();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        readClient.readBD(bank);
        req.setAttribute("clientMap", clientList);
        System.out.println(clientList.entrySet());


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/adminview/admin.jsp");
        requestDispatcher.forward(req, resp);
    }
}
