package app.servlets;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadAccount;
import app.bankApp.DBtextformat.ReadClient;
import app.bankApp.DBtextformat.ReaderCredit;
import app.entities.Account;
import app.entities.Client;
import app.entities.Credit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * this servlet Admin window
 * show information about the number of client and products
 */
@WebServlet("/bank_app/admin")
public class AdminServlet extends HttpServlet {
    Bank bank = Bank.getInstance();
    ReadClient readClient = ReadClient.getInstance();
    ReaderCredit readerCredit = ReaderCredit.getInstance();
    ReadAccount readAccount = ReadAccount.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        readClient.readBD(bank);
        readerCredit.readBD(bank);
        readAccount.readBD(bank);
        HashMap<String, Client> clientList = bank.getBankCollection().getClientHashMap();
        ArrayList<Credit> credits  = bank.getBankCollection().getCreditListOfBank();
        ArrayList<Account> accounts = bank.getBankCollection().getAccountList();

        req.setAttribute("accountList", accounts);
        req.setAttribute("creditList", credits);
        req.setAttribute("clientMap", clientList);
        System.out.println(clientList.entrySet());


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/adminview/admin.jsp");
        requestDispatcher.forward(req, resp);
    }
}
