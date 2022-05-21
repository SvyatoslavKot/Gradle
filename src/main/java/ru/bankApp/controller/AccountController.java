package ru.bankApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.accountFactory.AccountFactory;
import ru.bankApp.app.entities.Client;
import ru.bankApp.dao.AccountDao;
import ru.bankApp.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/bank_app/account")
public class AccountController {
    AccountService accountService;
    AccountDao accountDao;

    public AccountController(AccountService accountService, AccountDao accountDao) {
        this.accountService = accountService;
        this.accountDao = accountDao;
    }

    @GetMapping
    public String mainAccountView(){
        return "productView/accountViews/mainAccount";
    }

    @GetMapping("/open/")
    public String openView(HttpSession session, Model model){
       Client client = (Client) session.getAttribute("client");
       if (client!=null){
           model.addAttribute("client",client);
            return "productView/accountViews/OpenAccountView";
       }else {
           return "exceptionViews/notAutorisation";
       }
    }
    @PostMapping("/open/")
    public  String createAccount(HttpSession session,@RequestParam("term")  int term,
                                 @RequestParam("type") String type, @RequestParam("level") String level,
                                 Model model){
        AccountFactory accountFactory = new AccountFactory();
        Client client = (Client) session.getAttribute("client");
        Account account;
        if (client!=null){
            if (term!=0 && type!=null && type.length()>0 && level != null && level.length()>0){
                account = accountFactory.createAccount(client,type,term,"0000",level);
                model.addAttribute("client", client);
                model.addAttribute("account", account);
                accountService.genAccNum(account);
                accountService.addAccount(account);
                int id = accountService.getByNum(account.getAccount_num()).getId();
                System.out.println(account);
                return "redirect:/bank_app/account/open/"+id;
            }else return "productView/accountViews/OpenAccountView";
        }else return "exceptionViews/notAutorisation";
    }

    @GetMapping("/open/{id}")
    public String accountConfirm(@PathVariable("id")int id, Model model, HttpSession session){
        Account account = accountService.getById(id);
        Client client = (Client) session.getAttribute("client");
        model.addAttribute("client", client );
        model.addAttribute("account", account);
        return "productView/accountViews/confirmAccountView";
    }

    @DeleteMapping("/open/{id}")
    public String accRevocation(@PathVariable("id")int id){
        accountService.delete(id);
        return "redirect:/bank_app/account/";
    }

    @PostMapping("/open/{id}")
    public String addAcc(@PathVariable("id")int id, HttpSession session){
        Account account = accountService.getById(id);
        Client client = (Client) session.getAttribute("client");
        accountService.upDateClientId(account.getId(),client.getId());
        return "redirect:/bank_app/account/";
    }
    @GetMapping("/list/{id}")
    public String getClientAccount(@PathVariable("id") int id, HttpSession session, Model model, HttpServletRequest req){
        Client client = (Client) session.getAttribute("client");
        List<Account> accountList = accountService.accountsByClientId(client.getId());
        if (req.getParameter("sorted")!=null){
            if (req.getParameter("sorted").equals("name")){
                accountList = accountService.sortByName(accountList);
            }
            if (req.getParameter("sorted").equals("balance")){
                accountList = accountService.sortByBalance(accountList);
            }
            if (req.getParameter("sorted").equals("numh")){
                accountList = accountService.sortByNumHi(accountList);
            }
            if (req.getParameter("sorted").equals("numl")){
                accountList = accountService.sortByNumlow(accountList);
            }
            if (req.getParameter("sorted").equals("termlow")){
                accountList = accountService.sortByTermlow(accountList);
            }
            if (req.getParameter("sorted").equals("termhi")){
                accountList = accountService.sortByTermHi(accountList);
            }
        }

        model.addAttribute("client", client);
        model.addAttribute("accounts", accountList);
        return "productView/accountViews/profileAccountView";
    }

    @GetMapping("/{id}")
    public String itemAccount(@PathVariable("id")int id,HttpSession session, Model model){
        Client client = (Client) session.getAttribute("client");
        model.addAttribute("client", client);
        model.addAttribute("account",accountService.getById(id));
        return "productView/accountViews/itemAccountView";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAccount(@PathVariable("id") int id,HttpSession session){
        Client client = (Client)session.getAttribute("client");
        accountService.delete(id);
        return "redirect:/bank_app/account/list/"+client.getId();
    }

}
