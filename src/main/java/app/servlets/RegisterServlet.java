package app.servlets;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadClient;
import app.bankApp.DBtextformat.WriteClient;
import app.entities.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author SvyatoslavK
 * Servlet страницы регистрации профиля клиента
 * Mapping прописан в @WebServlet
 * */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    Client client ;
    Bank bank = Bank.getInstance();
    ReadClient readClient = ReadClient.getInstance();
    WriteClient writeClient = WriteClient.getInstance();
    /**
     * обрабатывает метод GET запросы со страницы 'register'
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        readClient.readBD(bank);
        System.out.println(bank.getBankCollection().getClientHashMap().entrySet());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/register.jsp");
        requestDispatcher.forward(req, resp);

    }

    /**
     * обрабатывает POST запросы со страницы 'register'
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String userName = req.getParameter("name");
         req.setAttribute("name", userName);
         String lastName = req.getParameter("lastName");
         req.setAttribute("lastName", lastName);
         String id = String.valueOf(bank.getBankCollection().getClientHashMap().size() + 1);
         String nickName = req.getParameter("nickName");
         req.setAttribute("nickName", nickName);
         String password1 = req.getParameter("password1");
         req.setAttribute("password1", password1);
         String password2 = req.getParameter("password2");
         req.setAttribute("password2", password2);

         System.out.println(userName+ " " + nickName);
        if (req.getParameter("enter") !=null) {
            if (userName.isEmpty() || userName== null
            ||lastName.isEmpty() || lastName == null
            ||nickName.isEmpty() || nickName ==null
            ||password1.isEmpty() || password1 == null
            ||password2.isEmpty() || password2 == null) {

                doGet(req,resp);
            }
            else if (!password1.equals(password2) ){
                System.out.println("password uncorrected");
                doGet(req,resp);
            }else {
                client = new Client(userName,lastName,id,nickName,password1);
                bank.getBankCollection().getClientHashMap().put(client.getNickName(), client);
                writeClient.writeClient(bank);

                HttpSession session = req.getSession();
                session.setAttribute("client", client);

                resp.sendRedirect("/main");
            }
        }



    }
}
