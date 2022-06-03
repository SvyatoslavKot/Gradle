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
import ru.bankApp.app.entities.creditFactory.Credit;
import ru.bankApp.service.AccountService;
import ru.bankApp.service.CreditService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/bank_app/client/money_operation/payment")
public class PaymentController {
    MoneyOperation moneyOperation = new MoneyOperation();
    CreditService creditService;
    AccountService accountService;

    public PaymentController(CreditService creditService, AccountService accountService) {
        this.creditService = creditService;
        this.accountService = accountService;
    }

    @GetMapping("/credit")
    public String creditView(HttpSession session, Model model){
        Client client = (Client) session.getAttribute("client");
        List<Account> accounts = accountService.accountsByClientId(client.getId());
        List<Credit> credits = creditService.getByClientId(client.getId());
        model.addAttribute("accounts", accounts);
        model.addAttribute("credits", credits);
        return "moneyOperationViews/payment/credit";
    }
    @PostMapping("/credit")
    public String yourself(@RequestParam("account")int account, @RequestParam("credit") int credit,
                           @RequestParam("value")double value){
        if (account!=0 || credit!=0 || value!=0){
            Account acc = accountService.getById(account);
            Credit cr = creditService.getById(credit);
            try {
                moneyOperation.paymentCredit(acc,cr,value);
                accountService.upDate(acc.getId(),acc);
                creditService.upDate(cr.getId(),cr);
                return "redirect:/bank_app/client/money_operation/main";
            } catch (AccountNotMoney e) {
                e.printStackTrace();
                return "redirect:/bank_app/client/money_operation/payment/credit";
            }
        }
        return "redirect:/bank_app/client/money_operation/payment/credit";
    }

    @GetMapping("/phone")
    public String phoneView(){
        return "moneyOperationViews/payment/phone";
    }
}
