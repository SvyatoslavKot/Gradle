package ru.bankApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bankApp.app.bankApp.tasksAdmin.StatusApplyCreditEnum;
import ru.bankApp.app.entities.ApplyCredit;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.EmployTask;
import ru.bankApp.app.entities.Employee;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.creditFactory.Credit;
import ru.bankApp.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("bank_app/employee")
public class EmployeeController {

    EmployeeService employeeService;
    ApplyTaskService applyTaskService;
    ApplyCreditService applyCreditService;
    ClientService clientService;
    CreditService creditService;
    AccountService accountService;

    public EmployeeController(EmployeeService employeeService, ApplyTaskService applyTaskService, ApplyCreditService applyCreditService,
    ClientService clientService, CreditService creditService, AccountService accountService) {
        this.employeeService = employeeService;
        this.applyTaskService = applyTaskService;
        this.applyCreditService = applyCreditService;
        this.clientService = clientService;
        this.creditService = creditService;
        this.accountService = accountService;
    }

    @GetMapping()
    public String login(HttpSession session){

            return "redirect:/bank_app/employee/main";
    }


    @GetMapping("/main")
    public String employeeMain(){
        return "employeeViews/employeeMain";
    }

    @GetMapping("/apples")
    public String employeeApples(){
        return "employeeViews/employeeApples";
    }



    @GetMapping("/apply")
    public String employeeGetApply( Model model){
        EmployTask task = applyTaskService.getTask();
        if (task==null){
            return "redirect:/bank_app/employee/apples";
        }
        ApplyCredit applyCredit = applyCreditService.getById(task.getApply_id());
        applyTaskService.delete(task.getId());
        Credit credit = creditService.getById(applyCredit.getCredit_id());
        Client client = clientService.getById(applyCredit.getClient_id());
        applyCreditService.calckSolvency(applyCredit);

        model.addAttribute("client", client);
        model.addAttribute("credit", credit);
        model.addAttribute("apply",applyCredit);
        return "employeeViews/employeeApply";
    }

    @PostMapping("/apply/{id}")
    public String applyCreditAdd(@PathVariable("id")int id){
        ApplyCredit applyCredit = applyCreditService.getById(id);
        applyCredit.setStatus(StatusApplyCreditEnum.APPROVED.status);
        applyCreditService.upDate(applyCredit.getId(),applyCredit);
        return "redirect:/bank_app/employee/apples";
    }

    @DeleteMapping("/apply/{id}")
    public String deleteApply(@PathVariable("id")int id){
        ApplyCredit applyCredit = applyCreditService.getById(id);
        Client client = clientService.getById(applyCredit.getClient_id());
        Credit credit = creditService.getById(applyCredit.getCredit_id());
        Account account = accountService.getById(credit.getAccount_link_id());
        if (account.getClient_id()==0){
            accountService.delete(account.getId());
        }
        creditService.delete(credit.getId());
        applyCredit.setStatus(StatusApplyCreditEnum.DENIED.status);
        applyCreditService.upDate(applyCredit.getId(),applyCredit);
        return "redirect:bank_app/employee/apples";
    }

    @GetMapping("apply/edit/{id}")
    public String editApply(@PathVariable("id")int id, Model model){
       ApplyCredit applyCredit = applyCreditService.getById(id);
       Credit credit = creditService.getById(applyCredit.getCredit_id());
        model.addAttribute("credit", credit);
       model.addAttribute("apply", applyCredit);
        return "employeeViews/employeeEditApply";
    }
    @GetMapping("/lists")
    public String listView(){
        return "employeeViews/employeeLists";
    }

    @GetMapping("/lists/credit")
    public String listCredit( Model model){
        List<Credit> credits = creditService.all();
        model.addAttribute("credits", credits);
        return "employeeViews/employeeCreditList";
    }

    @GetMapping("/lists/account")
    public String listAccount( Model model){
        List<Account> accounts = accountService.all();
        model.addAttribute("accounts", accounts);
        return "employeeViews/employeeAccountList";
    }

    @GetMapping("/lists/client")
    public String listClient( Model model){
        List<Client> clients = clientService.getAllClient();
        model.addAttribute("clients", clients);
        return "employeeViews/employeeClientList";
    }

    @GetMapping("/lists/apply")
    public String listApply( Model model){
        List<ApplyCredit> apples = applyCreditService.all();
        model.addAttribute("apples", apples);
        return "employeeViews/employeeApplyList";
    }
}
