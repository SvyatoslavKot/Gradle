package app.servlets;

import app.servlets.include.NavBarServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bank_app/main2")
public class Main2Servlet extends HttpServlet {
    NavBarServlet headerServlet = new NavBarServlet();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write(HtmlPage.START.htmlElement);
        headerServlet.navbar(resp,req);
        resp.getWriter().write("<div>\n" +
                "        <h4>Главная страница </h4>\n" +
                "        <div>\n" +
                "            <p>Контент главной страницы</p>\n" +
                "\n" +
                "        </div>\n" +
                "    </div>");

        resp.getWriter().write(HtmlPage.END.htmlElement);
    }
}
