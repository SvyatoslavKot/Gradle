package ru.bankApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bankApp.app.bankApp.tasksAdmin.StatusApplyCreditEnum;
import ru.bankApp.app.entities.ApplyCredit;
import ru.bankApp.app.entities.EmployTask;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.creditFactory.Credit;
import ru.bankApp.app.entities.creditFactory.CreditFactory;
import ru.bankApp.service.AccountService;
import ru.bankApp.service.ApplyCreditService;
import ru.bankApp.service.CreditService;
import ru.bankApp.service.EmployTaskService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("/bank_app/credits")
public class CreditController {
    CreditFactory creditFactory = new CreditFactory();
    AccountService accountService;
    CreditService creditService;
    EmployTaskService employTaskService;
    ApplyCreditService applyCreditService;


    public CreditController(AccountService accountService, ApplyCreditService applyService, CreditService creditService, EmployTaskService employTaskService) {
        this.creditService = creditService;
        this.accountService = accountService;
        this.employTaskService = employTaskService;
        this.applyCreditService = applyService;
    }

    @GetMapping()
    public String creditMain(){
        return "productView/creditViews/creditMain";
    }

    @GetMapping("/open/")
    public String openCredit(HttpSession session, Model model){
        Client client = (Client) session.getAttribute("client");
        if (client==null){
            return "exceptionViews/notAutorisation";
        }
        List<Account> accounts = accountService.accountsByClientId(client.getId());
        model.addAttribute("accounts", accounts);
        return "productView/creditViews/creditOpen";
    }

    @PostMapping("/open/")
    public  String calckCredit(HttpSession session, HttpServletRequest req){
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
        if (client==null){
            return "exceptionViews/notAutorisation";
        }
        if (sum==null||sum.length()<1||type==null||type.length()<1||term==null||term.length()<1||
                linkAcc==null||linkAcc.length()<1||family==null||family.length()<1||
                income==null||income.length()<1||otherCredit==null||otherCredit.length()<1||
                experience==null||experience.length()<1||age==null||age.length()<1||
                child==null||child.length()<1){
            return "redirect:/bank_app/credits/open/";
        }
        Credit credit = creditFactory.createCredit(client,Double.parseDouble(sum),type,Integer.parseInt(term));
        ApplyCredit applyCredit = new ApplyCredit(applyCreditService.genAccNum(),client.getId(),
                Integer.parseInt(child),family,Integer.parseInt(income),Integer.parseInt(experience),
                Integer.parseInt(age),Double.parseDouble(otherCredit));
        if (credit== null){
            applyCredit.setStatus(StatusApplyCreditEnum.DENIED.status);
            applyCreditService.add(applyCredit);
            return "redirect:/bank_app/";
        }
        applyCredit.setStatus(StatusApplyCreditEnum.PENDING.status);
        applyCredit.setCredit_id(credit.getId());
        EmployTask employTask = new EmployTask(applyCredit.getNumber());
        creditService.add(credit);
        applyCreditService.add(applyCredit);
        employTaskService.add(employTask);
        return "redirect:/bank_app/credits/";
    }
}
