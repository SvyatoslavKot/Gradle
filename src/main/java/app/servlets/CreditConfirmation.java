package app.servlets;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadClient;
import app.bankApp.DBtextformat.ReaderCredit;
import app.bankApp.DBtextformat.WriteCredit;
import app.entities.Credit;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/bank_app/confirmCredit", asyncSupported =true)
public class CreditConfirmation extends HttpServlet {
    private WriteCredit wr = WriteCredit.getInstance();

    Bank bank = Bank.getInstance();
    int count = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {

            }
            @Override
            public void onTimeout(AsyncEvent event) throws IOException {

            }

            @Override
            public void onError(AsyncEvent event) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
            }
        });

        asyncContext.start(new Runnable() {
            boolean isActive = true;
            void disable(){
                isActive = false;
            }
            @Override
            public void run() {
                while (count < 6) {
                    System.out.println(count);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
               System.out.println("End async");
            }
        });

        asyncContext.complete();
        RequestDispatcher requestDispatcher =  req.getRequestDispatcher("/views/bankProductViews/confirmCredit.jsp");
        requestDispatcher.forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("confirm")!=null){
            Credit credit = (Credit) session.getAttribute("creditCalck");

            bank.getBankCollection().getCreditListOfBank().add(credit);
            wr.writeCredit(bank);
            session.removeAttribute("creditCalck");
            resp.sendRedirect("/bank_app/credit/main");
        }else if (req.getParameter("cancel")!=null){
            session.removeAttribute("creditCalck");
            resp.sendRedirect("/bank_app/credit/main");
        }

    }
}
