package app.servlets;

import app.entities.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author SvyatoslavK
 * Servlet страницы профиля клиента
 * Mapping прописан в @WebServlet
 * */



@WebServlet("/profileview")
public class ProfileServlet extends HttpServlet {
    Client client = new Client();

     /**
     * обрабатывает GET запросы со страницы '/profileview'
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Client client = (Client) servletContext.getAttribute("client");
        System.out.println(client);

        req.setAttribute("client" , client);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/profileview.jsp");
        requestDispatcher.forward(req, resp);
    }
}
