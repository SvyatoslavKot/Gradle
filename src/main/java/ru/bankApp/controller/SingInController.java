package ru.bankApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bankApp.app.bankApp.exeption.ClientAddExeption;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.Employee;
import ru.bankApp.service.ClientService;
import ru.bankApp.service.EmployeeService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value ="/bank_app/sing_in/")
public class SingInController {
    ClientService clientService;
    EmployeeService employeeService;
    public SingInController(ClientService clientService, EmployeeService employeeService) {
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public  String singInView(HttpServletRequest req, Model model){
        System.out.println("sing IN");
        Client client;
        model.addAttribute("client", new Client());
        HttpSession session = req.getSession();
        client = (Client) session.getAttribute("client");
        if (client!=null){
            return "redirect:/bank_app/client/profile/"+client.getId();
        }
        return "navBar/logging";
    }

    @PostMapping
    public  String logging(HttpSession session,@RequestParam("phone")String phone,@RequestParam("password")String password){
        String p = phone;
        String pass = password;
        if (p!=null&&p.length()>0&&pass!=null&&pass.length()>0){
            try {
                Client client =clientService.checkPassword(p,pass);
                if (client!=null){
                    session.setAttribute("client", client);
                    if (session.getAttribute("employee")!=null){
                        session.removeAttribute("employee");
                    }
                    return "redirect:/bank_app/client/profile/"+client.getId();
                }
                return "navBar/logging";
            } catch (ClientAddExeption e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return "navBar/logging";
            }
        }
        return "navBar/logging";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        Client client;
        client = (Client) session.getAttribute("client");
        if (client!= null){
            session.removeAttribute("client");
            return "redirect:/bank_app/";
        }else {
            return "redirect:/bank_app/sing_in/";
        }
    }

    @GetMapping("/employee")
    public String loginViewEmpl(){
        return "employeeViews/employeeLoggin";
    }
    @PostMapping("/employee")
    public String singIn(HttpSession session, @RequestParam("login")String login, @RequestParam("password")String password){
        if (login!=null||login.length()<1&&password!=null||password.length()<1){
            Employee employee;
            employee = employeeService.getByPhone(login);
            if (employee.getPassword().equals(password)){
                session.setAttribute("employee", employee);
                if (session.getAttribute("client")!=null){
                    session.removeAttribute("client");
                }
                return "redirect:/bank_app/employee/main";
            }
        }
        return "redirect:/bank_app/sing_in/employee";
    }
}
