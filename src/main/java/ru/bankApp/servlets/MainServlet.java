package ru.bankApp.servlets;

import ru.bankApp.app.bankApp.Bank;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * @author SvyatoslavK
 * Servlet главной страница в web.xml прописан маппинг на main.jsp
 * */

@WebServlet("/bank_app/main")
public class MainServlet extends HttpServlet {
    final static String TEXT = "Заполните поля 'имя' и 'пароль'!";
    Bank bank = Bank.getInstance();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

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
