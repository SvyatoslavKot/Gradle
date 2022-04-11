package app.servlets;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReaderCredit;
import app.bankApp.FactoryProduct.CreditFactory.CreditFactory;
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
import java.util.TreeSet;

@WebServlet(value = "/bank_app/credit/open",  asyncSupported = true)
public class CreditOpenServlet extends HttpServlet {
    private ReaderCredit rc = ReaderCredit.getInstance();
    Bank bank = Bank.getInstance();
    CreditFactory creditFactory = new CreditFactory();
    private Client client;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/bankProductViews/openCreditView.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        rc.readBD(bank);
        if (req.getParameter("calck")!= null){
            if (req.getParameter("sum")!= null ||req.getParameter("sum").isEmpty()
                    && req.getParameter("term")!=null || req.getParameter("term").isEmpty()
                    && req.getParameter("type")!=null|| req.getParameter("type").isEmpty()){
                HttpSession session = req.getSession();
                client = (Client) session.getAttribute("client" );
                if (client!= null){
                    Credit credit = creditFactory.createCredit(Bank.getInstance(),client,
                            Integer.parseInt(req.getParameter("sum")),
                            req.getParameter("type"),
                            Integer.parseInt(req.getParameter("term")));

                            session.setAttribute("creditCalck" , credit);

                    resp.sendRedirect("/bank_app/confirmCredit");

                }else {
                    doGet(req,resp);

                }
            }else {
                doGet(req,resp);

            }

        }
    }

}
