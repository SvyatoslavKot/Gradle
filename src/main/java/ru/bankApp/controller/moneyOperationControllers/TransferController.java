package ru.bankApp.controller.moneyOperationControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bankApp.app.bankApp.exeption.AccountNotMoney;
import ru.bankApp.app.bankApp.serviceBank.moneyOperation.MoneyOperation;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.service.AccountService;
import ru.bankApp.service.ClientService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/bank_app/client/money_operation/transfer")
public class TransferController {
    AccountService accountService;
    ClientService clientService;
    MoneyOperation moneyOperation = new MoneyOperation();

    public TransferController(AccountService accountService, ClientService clientService) {
        this.accountService = accountService;
        this.clientService = clientService;
    }

    @GetMapping("/yourself")
    public String yourselfView(HttpSession session, Model model){
        Client client = (Client) session.getAttribute("client");
        List<Account> aSender = accountService.accountsByClientId(client.getId());
        List<Account> aAddressee = accountService.accountsByClientId(client.getId());
        model.addAttribute("sender", aSender);
        model.addAttribute("addressee", aAddressee);
        return "moneyOperationViews/transfer/transferYourself";
    }

    @PostMapping("/yourself")
    public String yourself(@RequestParam("sender")int sender, @RequestParam("addressee") int addressee,
                           @RequestParam("value")double value){
        if (sender!=0 || addressee!=0 || value!=0){
           Account aSender = accountService.getById(sender);
           Account aAddressee = accountService.getById(addressee);
            try {
                moneyOperation.transferMoney(aSender,aAddressee,value);
                accountService.upDate(aSender.getId(),aSender);
                accountService.upDate(aAddressee.getId(),aAddressee);
                return "redirect:/bank_app/client/money_operation/main";
            } catch (AccountNotMoney e) {
                e.printStackTrace();
                return "redirect:/bank_app/client/money_operation/transfer/yourself";
            }
        }
            return "redirect:/bank_app/client/money_operation/transfer/yourself";
    }

    @GetMapping("/bank")
    public String bankView(HttpSession session, Model model){
        Client client = (Client) session.getAttribute("client");
        List<Account> aSender = accountService.accountsByClientId(client.getId());
        model.addAttribute("sender", aSender);
        return "moneyOperationViews/transfer/anotherBank";
    }
    @PostMapping("/bank")
    public String bank(@RequestParam("sender")int sender, @RequestParam("addressee") String addressee,
                         @RequestParam("value")double value){
        if (sender!=0 || addressee!=null || addressee.length()<1 || value!=0){
            Account aSender = accountService.getById(sender);
            Account aAddressee;
                try {
                    moneyOperation.transferMoney(aSender,null,value);
                    accountService.upDate(aSender.getId(),aSender);
                    return "redirect:/bank_app/money_operation/main";
                } catch (AccountNotMoney e) {
                    e.printStackTrace();
                    return "redirect:/bank_app/client/money_operation/transfer/yourself";
            }
        }
        return "redirect:/bank_app/client/money_operation/transfer/yourself";
    }

    @GetMapping("/client")
    public String clientfView(HttpSession session, Model model){
        Client client = (Client) session.getAttribute("client");
        List<Account> aSender = accountService.accountsByClientId(client.getId());
        model.addAttribute("sender", aSender);
        return "moneyOperationViews/transfer/anotherClient";
    }
    @PostMapping("/client")
    public String client(@RequestParam("sender")int sender, @RequestParam("addressee") String addressee,
                         @RequestParam("value")double value){
        if (sender!=0 || addressee!=null || addressee.length()<1 || value!=0){
            Account aSender = accountService.getById(sender);
            Account aAddressee = accountService.getByNum(addressee);
            if (aAddressee!=null){
                try {
                    moneyOperation.transferMoney(aSender,aAddressee,value);
                    accountService.upDate(aSender.getId(),aSender);
                    accountService.upDate(aAddressee.getId(),aAddressee);
                    return "redirect:/bank_app/client/money_operation/main";
                } catch (AccountNotMoney e) {
                    e.printStackTrace();
                    return "redirect:/bank_app/client/money_operation/transfer/yourself";
                }
            }
        }
        return "redirect:/bank_app/client/money_operation/transfer/yourself";
    }
}
