package ru.bankApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bankApp.app.entities.Employee;
import ru.bankApp.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/bank_app/admin")
public class AdminController {

    EmployeeService employeeService;

    public AdminController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String adminView(){
        return "adminViews/adminLogin";
    }

    @PostMapping()
    public String adminLogin(@RequestParam("login")String login,@RequestParam("password")String password){
        if (login!=null||login.length()<1&&password!=null||password.length()<1){
            if (login.equals("admin")){
                if (password.equals("admin")){
                    return "redirect:/bank_app/admin/main";
                }
            }
        }
        return "redirect:/bank_app/admin";
    }
    @GetMapping("/main")
        public String adminMain(){
            return"adminViews/adminMain";
        }

    @GetMapping("/employs")
    public String adminEmploys(Model model){
        List<Employee>  employees = employeeService.listAll();
        model.addAttribute("employees", employees);
        return "adminViews/adminEmploys";
    }

    @GetMapping("/employee/{id_acc}")
    public String adminEmployee(@PathVariable("id_acc")int id, Model model){
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return"adminViews/adminEmployeeItem";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteProfile(@PathVariable("id") int id){
        employeeService.delete(id);
        return "redirect:/bank_app/admin/employs";
    }
    @GetMapping("/employee/add")
    public String createEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "adminViews/adminAddEmployee";
    }
    @PostMapping("/employee/add")
    public  String addEmployee(@ModelAttribute("employee")Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/bank_app/admin/employs";
    }
}
