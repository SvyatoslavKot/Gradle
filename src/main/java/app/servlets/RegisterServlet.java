package app.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author SvyatoslavK
 * Servlet страницы регистрации профиля клиента
 * Mapping прописан в @WebServlet
 * */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    /**
     * обрабатывает метод GET запросы со страницы 'register'
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        super.doPost(req, resp);
    }
}
