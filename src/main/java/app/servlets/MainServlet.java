package app.servlets;

import app.bankApp.Bank;
import app.entities.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLConnection;

/**
 * @author SvyatoslavK
 * Servlet главной страница в web.xml прописан маппинг на main.jsp
 * */

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    /**
     * константа сообщения в форме заполнения
     * */
    final static String TEXT = "Заполните поля 'имя' и 'пароль'!";
    Client client = new Client();
    /**
     * метод обрабатывает GET запросы
     * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * отправляет в request страницу main.jsp
         * */
        Bank bank = Bank.getInstance();
        req.setAttribute("bank", bank);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/main.jsp");
        requestDispatcher.forward(req, resp);
    }
    /**
     * метод обрабатывает POST запросы
     * @throws ServletException
     * @throws IOException
     *
     * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //получает значение с параметром "name"
        String name = req.getParameter("name");
        //получает значение с параметром "pass"
        String password = req.getParameter("pass");
//цикл который получает параметр кнопок из request
        if (req.getParameter("register")!= null){
            // отправляет клиента на страницу /register
            resp.sendRedirect("/register" );
        }else if (req.getParameter("enter")!= null){
            if (name.isEmpty() || password.isEmpty()){
                //устанавливает значение атрибута с именем "text", если поля в форме пустые
                req.setAttribute("text", TEXT);
                //выполняет метод doGet для перезапуска страницы
                doGet(req,resp);
            }else
                //отправляет клиента на страницу "/profileview" , если поля заполнены
                client.setPassword(password);
            client.setUserName(name);
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute("client" , client);
            resp.sendRedirect("/profileview");
        }
    }
}
