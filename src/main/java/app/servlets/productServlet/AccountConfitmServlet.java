package app.servlets.productServlet;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.WriteAccount;
import app.entities.Account;
import app.entities.Credit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpClient;
@WebServlet("/bank_app/account/confirm_account")
public class AccountConfitmServlet extends HttpServlet {
    WriteAccount wa = WriteAccount.getInstance();
    Bank bank = Bank.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/bankProductViews/confirmAccount.jsp");
        requestDispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("confirm")!=null){
            Account account = (Account) session.getAttribute("accountCalk");
            bank.getBankCollection().getAccountList().add(account);

            wa.writeAccount(bank);
            session.removeAttribute("accountCalk");
            resp.sendRedirect("/bank_app/credit/main");
        }else if (req.getParameter("cancel")!=null){
            session.removeAttribute("creditCalck");
            resp.sendRedirect("/bank_app/credit/main");
        }
    }
}
