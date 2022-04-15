package app.servlets.profileView;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReaderCredit;
import app.bankApp.bankCollection.SortAccount;
import app.bankApp.bankCollection.SortCreditList;
import app.entities.Account;
import app.entities.Client;
import app.entities.Credit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet("/bank_app/profile/account")
public class ProfileAccountView extends HttpServlet {
    Bank bank = Bank.getInstance();
    ReaderCredit rc = ReaderCredit.getInstance();
    SortAccount sortAccount = new SortAccount();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Client clientSesion = (Client) session.getAttribute("client");
        Set<Account> accounts = clientSesion.getAccountListPersn();//client.getCreditListPersn();
        List<Account> sortList = new ArrayList<>(accounts);

        System.out.println(accounts.size() + " "+ sortList.size());
        if (req.getParameter("sortButton")!= null){
            if (req.getParameter("sortParam").equals("1")){
                sortList = sortAccount.sortByMoneyLow(sortList);
                System.out.println(sortList.get(1));
            }else if (req.getParameter("sortParam").equals("2")) {
                sortList = sortAccount.sortByMoneyHight(sortList);
            }else if (req.getParameter("sortParam").equals("3")) {
                sortList = sortAccount.sortByName(sortList);
            }else if (req.getParameter("sortParam").equals("4")) {
                sortList = sortAccount.sortByPaymentLow(sortList);
            }else if (req.getParameter("sortParam").equals("5")) {
                sortList = sortAccount.sortByPaymentHeight(sortList);
            }
        }else {
            sortList = sortAccount.sortByName(sortList);
        }
        req.setAttribute("accounts" , sortList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/profileViews/profileAccountView.jsp");
        requestDispatcher.forward(req,resp);
    }
}
