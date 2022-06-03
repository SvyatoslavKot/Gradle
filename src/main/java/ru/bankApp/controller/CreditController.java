package ru.bankApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bankApp.app.bankApp.tasksAdmin.StatusApplyCreditEnum;
import ru.bankApp.app.entities.ApplyCredit;
import ru.bankApp.app.entities.EmployTask;
import ru.bankApp.app.entities.Employee;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.accountFactory.AccountFactory;
import ru.bankApp.app.entities.creditFactory.Credit;
import ru.bankApp.app.entities.creditFactory.CreditFactory;
import ru.bankApp.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/bank_app/")
public class CreditController {
    AccountFactory accountFactory = new AccountFactory();
    CreditFactory creditFactory = new CreditFactory();
    AccountService accountService;
    CreditService creditService;
    ApplyTaskService employTaskService;
    ApplyCreditService applyCreditService;
    ClientService clientService;


    public CreditController(AccountService accountService, ApplyCreditService applyService, CreditService creditService, ApplyTaskService employTaskService,
    ClientService clientService) {
        this.creditService = creditService;
        this.accountService = accountService;
        this.employTaskService = employTaskService;
        this.applyCreditService = applyService;
        this.clientService = clientService;
    }

    @GetMapping("/credits/")
    public String creditMain(){
        return "productView/creditViews/creditMain";
    }

    @GetMapping("/client/credits/open/")
    public String openCredit(HttpSession session, Model model){
        Client client = (Client) session.getAttribute("client");
        List<Account> accounts = accountService.accountsByClientId(client.getId());
        accounts.add(new Account());
        model.addAttribute("accounts", accounts);
        return "productView/creditViews/creditOpen";
    }

    @PostMapping("/client/credits/open/")
    public  String calckCredit(HttpSession session, HttpServletRequest req,Model model){
        String sum = req.getParameter("sum");
        String type = req.getParameter("type");
        String term = req.getParameter("term");
        String linkAcc = req.getParameter("linkAccount");
        String family = req.getParameter("family");
        String income = req.getParameter("income");
        String otherCredit = req.getParameter("otherCredit");
        String experience = req.getParameter("experience");
        String age = req.getParameter("age");
        String child = req.getParameter("child");

        Client client = (Client) session.getAttribute("client");
        Account account;
        Credit credit;
        if (sum==null||sum.length()<1||type==null||type.length()<1||term==null||term.length()<1||
                linkAcc==null||linkAcc.length()<1||family==null||family.length()<1||
                income==null||income.length()<1||otherCredit==null||otherCredit.length()<1||
                experience==null||experience.length()<1||age==null||age.length()<1||
                child==null||child.length()<1){
            return "redirect:/bank_app/client/credits/open/";
        }
        credit = creditFactory.createCredit(client,Double.parseDouble(sum),type,Integer.parseInt(term));
        creditService.genAccNum(credit);

        if (linkAcc.equals("new")){
            account = accountFactory.createAccount(client,"STANDARD",Integer.parseInt(term),"0000","STANDARD");
            accountService.genAccNum(account);
            accountService.addAccount(account);
            credit.setAccount_link_id(accountService.getByNum(account.getAccount_num()).getId());
        }else {
            credit.setAccount_link_id(Integer.parseInt(linkAcc));
        }

        ApplyCredit applyCredit = new ApplyCredit(applyCreditService.genAccNum(),client.getId(),
                Integer.parseInt(child),family,Integer.parseInt(income),Integer.parseInt(experience),
                Integer.parseInt(age),Double.parseDouble(otherCredit));
        if (credit== null){
            applyCredit.setStatus(StatusApplyCreditEnum.DENIED.status);
            applyCreditService.add(applyCredit);
            return "redirect:/bank_app/client/credits/applySent";
        }

        creditService.add(credit);

        applyCredit.setStatus(StatusApplyCreditEnum.PENDING.status);
        applyCredit.setCredit_id(creditService.getByNum(credit.getAccount_number()).getId());
        applyCreditService.add(applyCredit);
        EmployTask employTask = new EmployTask(applyCreditService.getByNum(applyCredit.getNumber()).getId(),applyCredit.getNumber());


        employTaskService.add(employTask);
        model.addAttribute("apply",applyCredit);
        return "redirect:/bank_app/client/credits/applySent/";
    }

    @GetMapping("/client/credits/applySent/")
    public String applySent(){

        return "productView/creditViews/creditApplySent";
    }

    @GetMapping("/client/credits/list/{id}")
    public String getClientAccount(@PathVariable("id") int id, HttpSession session, Model model, HttpServletRequest req){
        Client client = clientService.getById(id);
        List<Credit> creditList = creditService.getByClientId(id);
        if (req.getParameter("sorted")!=null){
            if (req.getParameter("sorted").equals("name")){
                creditList = creditService.sortByName(creditList);
            }
            if (req.getParameter("sorted").equals("balance")){
                creditList = creditService.sortByBalance(creditList);
            }
            if (req.getParameter("sorted").equals("numh")){
                creditList = creditService.sortByNumHi(creditList);
            }
            if (req.getParameter("sorted").equals("numl")){
                creditList = creditService.sortByNumlow(creditList);
            }
            if (req.getParameter("sorted").equals("termlow")){
                creditList = creditService.sortByTermlow(creditList);
            }
            if (req.getParameter("sorted").equals("termhi")){
                creditList = creditService.sortByTermHi(creditList);
            }
        }

        model.addAttribute("client", client);
        model.addAttribute("credits", creditList);
        return "productView/creditViews/profileCreditsView";
    }

    @GetMapping("credits/item/{id}")
    public String itemAccount(@PathVariable("id")int id,HttpSession session, Model model){
        Employee employee = (Employee) session.getAttribute("employee");
        Client client = (Client) session.getAttribute("client");
        model.addAttribute("employee", employee);
        model.addAttribute("client", client);
        model.addAttribute("credit",creditService.getById(id));
        return "productView/creditViews/creditItem";
    }
}
