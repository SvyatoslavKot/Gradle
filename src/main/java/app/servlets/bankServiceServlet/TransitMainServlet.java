package app.servlets.bankServiceServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/bank_app/payment/taransit/main")
public class TransitMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/bankServiceViews/transitMainView.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (req.getParameter("ourSelf")!=null){
           session.setAttribute("typeTransit", "ourSelf");
           resp.sendRedirect("/bank_app/payment/taransit");
        }else if (req.getParameter("clientBank")!=null){
            session.setAttribute("typeTransit", "clientBank");
            resp.sendRedirect("/bank_app/payment/taransit");
        }else if (req.getParameter("clientOtherBank")!=null){
            session.setAttribute("typeTransit", "clientOtherBank");
            resp.sendRedirect("/bank_app/payment/taransit");
        }
    }
}
