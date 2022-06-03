package ru.bankApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bankApp.app.entities.ApplyCredit;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.creditFactory.Credit;
import ru.bankApp.service.AccountService;
import ru.bankApp.service.ApplyCreditService;
import ru.bankApp.service.ClientService;
import ru.bankApp.service.CreditService;

import java.util.List;

@Controller
@RequestMapping("/bank_app/client/apply")
public class ApplyController {
    ClientService clientService;
    ApplyCreditService applyCreditService;
    CreditService creditService;
    AccountService accountService;

    public ApplyController(ClientService clientService, ApplyCreditService applyCreditService, CreditService creditService, AccountService accountService) {
        this.clientService = clientService;
        this.applyCreditService = applyCreditService;
        this.creditService = creditService;
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public String applyClientView(@PathVariable("id")int id, Model model){
        Client client = clientService.getById(id);
        List<ApplyCredit> applyCredits = applyCreditService.all();
        model.addAttribute("client",client);
        model.addAttribute("apples" , applyCredits);
        return  "productView/creditViews/creditApply";
    }
    @PostMapping("/add/{id}")
    public String addCredit(@PathVariable("id")int id){
        ApplyCredit applyCredit = applyCreditService.getById(id);
        Client client = clientService.getById(applyCredit.getClient_id());
        Credit credit = creditService.getById(applyCredit.getCredit_id());
        Account account = accountService.getById(credit.getAccount_link_id());
        if (account.getClient_id()==0){
            accountService.upDateClientId(account.getId(), client.getId());
        }
        creditService.upDateClientId(credit.getId(), client.getId());
        applyCreditService.delete(applyCredit.getId());
        return "redirect:/bank_app/client/apply/"+client.getId();
    }

    @DeleteMapping("delete/{id}")
    public  String deleteApply(@PathVariable("id")int id){
        ApplyCredit applyCredit = applyCreditService.getById(id);
        Client client = clientService.getById(applyCredit.getClient_id());
        Credit credit = creditService.getById(applyCredit.getCredit_id());
        Account account = accountService.getById(credit.getAccount_link_id());
        if (account.getClient_id()==0){
            accountService.delete(account.getId());
        }
        creditService.delete(credit.getId());
        applyCreditService.delete(applyCredit.getId());
        return "redirect:/bank_app/client/apply/"+client.getId();
    }
}
