package app.servlets;

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

/**
 * @author SvyatoslavK
 * Servlet страницы профиля клиента
 * Mapping прописан в @WebServlet
 * */



@WebServlet("/bank_app/profileview")
public class ProfileServlet extends HttpServlet {

    String nickName;
    String password;
    PasswordCheck passwordCheck = new PasswordCheck();
     /**
     * обрабатывает GET запросы со страницы '/profileview'
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        ServletContext servletContext = getServletContext();
        Client client = (Client) servletContext.getAttribute("client");
        System.out.println(client);

        req.setAttribute("client" , client);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/profileViews/profileview.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        Client client = (Client) session.getAttribute("client");
        //получает значение с параметром "name"
        nickName = req.getParameter("name");
        //получает значение с параметром "pass"
        password = req.getParameter("pass");
        //цикл который получает параметр кнопок из request

        if (req.getParameter("exit")!= null){
            ServletContext servletContext = getServletContext();
            servletContext.removeAttribute("client" );
            resp.sendRedirect("/bank_app/main");
            System.out.println(servletContext.getAttribute("client"));
        }else if (req.getParameter("register")!= null){
            // отправляет клиента на страницу /register
            resp.sendRedirect("/bank_app/register" );
        }else if (req.getParameter("enter")!= null){

            if (!nickName.isEmpty() && !password.isEmpty()){
                //отправляет клиента на страницу "/profileview" , если поля заполнены
                client = passwordCheck.chekPassword(nickName, password);
                if (client!=null){
                    System.out.println(client);
                    session.setAttribute("client" , client);
                    resp.sendRedirect("/bank_app/main");
                }else {
                    doGet(req, resp);
                }
            }else doGet(req, resp);
        }
    }
}
