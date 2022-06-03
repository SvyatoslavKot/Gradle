package ru.bankApp.filter;

import org.springframework.stereotype.Component;
import ru.bankApp.app.entities.Client;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AdminFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Client client = (Client) req.getSession().getAttribute("client");
        String path = req.getServletPath();
        if (client==null){
            resp.sendRedirect("/bank_app/admin/");
        }else {

            chain.doFilter(request, response);
        }


    }
}
