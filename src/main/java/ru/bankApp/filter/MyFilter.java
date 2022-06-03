package ru.bankApp.filter;

import org.springframework.stereotype.Component;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.Employee;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getServletPath();
        String url = String.valueOf(req.getRequestURL());
        if (url.contains("/bank_app/client/")){
            Client client = (Client) req.getSession().getAttribute("client");
            if (client==null){
                resp.sendRedirect("/bank_app/sing_in/");
            }else {

                chain.doFilter(request, response);
            }
            String  u = url.split("/client/")[1];
            System.out.println(u);
        }
        else if (url.contains("/bank_app/employee/")){
            Employee employee = (Employee) req.getSession().getAttribute("employee");
            if (employee==null){
                resp.sendRedirect("/bank_app/sing_in/employee");
            }else {

                chain.doFilter(request, response);
            }
            String  u = url.split("/employee/")[0];
            System.out.println(u);
        }
        else {
            chain.doFilter(request, response);
        }
    }
}
