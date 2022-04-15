package app.servlets.profileView;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadClient;
import app.bankApp.DBtextformat.ReaderCredit;
import app.bankApp.bankCollection.SortCreditList;
import app.entities.Client;
import app.entities.Credit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/bank_app/profile/credit")
public class ProfileCreditView extends HttpServlet {
    Bank bank = Bank.getInstance();
    ReaderCredit rc = ReaderCredit.getInstance();
    SortCreditList sortCreditList = new SortCreditList();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Client clientSesion = (Client) session.getAttribute("client");
        Set<Credit> credits = clientSesion.getCreditListPersn();//client.getCreditListPersn();
        List<Credit> sortList = new ArrayList<>(credits);

        System.out.println(credits.size() + " "+ sortList.size());
        if (req.getParameter("sortButton")!= null){
            if (req.getParameter("sortParam").equals("1")){
                 sortList = sortCreditList.sortByAmountLow(sortList);
                 System.out.println(sortList.get(1));
            }else if (req.getParameter("sortParam").equals("2")) {
                sortList = sortCreditList.sortByAmountHight(sortList);
            }else if (req.getParameter("sortParam").equals("3")) {
                sortList = sortCreditList.sortByName(sortList);
            }else if (req.getParameter("sortParam").equals("4")) {
                sortList = sortCreditList.sortByDate(sortList);
            }
        }else {
            sortList = sortCreditList.sortByDate(sortList);
        }
        req.setAttribute("credits" , sortList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/profileViews/profileCreditView.jsp");
        requestDispatcher.forward(req,resp);


    }


}
