package app.servlets;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadClient;
import app.entities.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLConnection;

/**
 * @author SvyatoslavK
 * Servlet главной страница в web.xml прописан маппинг на main.jsp
 * */

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    final static String TEXT = "Заполните поля 'имя' и 'пароль'!";
    Client client = new Client();
    ReadClient readClient = ReadClient.getInstance();
    Bank bank = Bank.getInstance();
    /**
     * метод обрабатывает GET запросы
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        readClient.readBD(bank);
        System.out.println(bank.getBankCollection().getClientHashMap().entrySet());
        ServletContext servletContext = getServletContext();
        Client client = (Client) servletContext.getAttribute("client");
        System.out.println(client);

        req.setAttribute("client" , client);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/main.jsp");
        requestDispatcher.forward(req, resp);

       // if (req.getParameter("profileButton")!=null){
         //   resp.sendRedirect("/profileview");
       // }
    }

    /**
     * метод обрабатывает POST запросы
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        }

}
