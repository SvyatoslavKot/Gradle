package app.servlets;

import app.bankApp.Bank;
import app.bankApp.DBtextformat.ReadClient;
import app.entities.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.net.URLConnection;

/**
 * @author SvyatoslavK
 * Servlet главной страница в web.xml прописан маппинг на main.jsp
 * */

@WebServlet("/bank_app/main")
public class MainServlet extends HttpServlet {
    final static String TEXT = "Заполните поля 'имя' и 'пароль'!";
    ReadClient readClient = ReadClient.getInstance();
    Bank bank = Bank.getInstance();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        readClient.readBD(bank);
    }

    /**
     * метод обрабатывает GET запросы
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8"); //кодировка utf-8
        readClient.readBD(bank);// чтение клиентов из txt.файла

        ServletContext servletContext = getServletContext();// получаем контекст
        servletContext.setAttribute("bank", bank);//кладем в контекс приложения объект bank

        getServletContext().getRequestDispatcher("/views/main.jsp").forward(req, resp);//формируем страницу
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
