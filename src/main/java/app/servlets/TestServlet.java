package app.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bank_app/test")
public class TestServlet extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {

            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            try {
                writer.println("<h2>Hello from HelloServlet</h2>");
            } finally {
                writer.close();
            }

    }
}
