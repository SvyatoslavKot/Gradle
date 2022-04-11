package app.servlets;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadAccount;
import app.bankApp.DBtextformat.ReadClient;
import app.bankApp.DBtextformat.ReaderCredit;
import app.bankApp.serviceBank.PasswordCheck;
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
@WebServlet("/bank_app/logining")
public class LoginingServlet extends HttpServlet {
    final static String TEXT = "Заполните поля 'имя' и 'пароль'!";
    Client client = new Client();
    ReadClient readClient = ReadClient.getInstance();
    ReaderCredit readerCredit = ReaderCredit.getInstance();
    ReadAccount readAccount = ReadAccount.getInstance();
    PasswordCheck passwordCheck = new PasswordCheck();
    String nickName;
    String password;
    String a = "Заполни форму";
    String b = "Здравстуйте";
    /**
     * метод обрабатывает GET запросы
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // отправляет в запрос на страницу main.jsp
        Bank bank = Bank.getInstance();
        readClient.readBD(bank);
        readerCredit.readBD(bank);
        readAccount.readBD(bank);
        // отправил атрибут на страницу с именем банк
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("bank", bank);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/logining.jsp");
        requestDispatcher.forward(req, resp);
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
        //получает значение с параметром "name"
        nickName = req.getParameter("name");
        //получает значение с параметром "pass"
        password = req.getParameter("pass");
        //цикл который получает параметр кнопок из request
        if (req.getParameter("register")!= null){
            // отправляет клиента на страницу /register
            resp.sendRedirect("/bank_app/register" );
        }else if (req.getParameter("enter")!= null){

            if (!nickName.isEmpty() && !password.isEmpty()){
                //отправляет клиента на страницу "/profileview" , если поля заполнены
                client = passwordCheck.chekPassword(nickName, password);
                if (client!=null){
                    System.out.println(client);
                    HttpSession session = req.getSession();
                    session.setAttribute("client" , client);
                    resp.sendRedirect("/bank_app/main");
                }else {
                    doGet(req, resp);
                }
        }else doGet(req, resp);
    }else doGet(req, resp);
}
}
