package app.servlets.productServlet;

import app.bankApp.Bank;
import app.bankApp.FactoryProduct.accountFactory.AccountFactory;
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
import java.net.http.HttpClient;
@WebServlet("/bank_app/account/open")
public class AccountOpenServlet extends HttpServlet {
    Client client;
    Bank bank = Bank.getInstance();
    AccountFactory af = new AccountFactory();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/bankProductViews/openAccountView.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("enter")!=null){
            if (req.getParameter("level")!= null || !req.getParameter("level").isEmpty()
                    && req.getParameter("term")!= null || !req.getParameter("term").isEmpty()
                    && req.getParameter("type") !=null || !req.getParameter("type").isEmpty() ){
                HttpSession session = req.getSession();
                client = (Client) session.getAttribute("client" );
                if (client!= null){
                    String level = req.getParameter("level");
                    int term = Integer.parseInt(req.getParameter("term"));
                    String type = req.getParameter("type");

                    Account account = af.createAccount(bank,client,type,term, "000", level);
                        System.out.println(account);
                    session.setAttribute("accountCalk" , account);
                    resp.sendRedirect("/bank_app/account/confirm_account");
                }else {
                    doGet(req,resp);
                }
                }else {
                doGet(req,resp);
                }
            }else if (req.getParameter("cancel") != null){
            resp.sendRedirect("/bank_app/account/main");
        }
    }
}
