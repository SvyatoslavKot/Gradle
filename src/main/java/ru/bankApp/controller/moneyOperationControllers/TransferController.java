package ru.bankApp.controller.moneyOperationControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank_app/money_operation/transfer")
public class TransferController {

    @GetMapping("/yourself")
    public String yourselfView(){
        return "moneyOperationViews/transfer/transferYourself";
    }

    @GetMapping("/bank")
    public String bankView(){
        return "moneyOperationViews/transfer/anotherBank";
    }

    @GetMapping("/client")
    public String clientfView(){
        return "moneyOperationViews/transfer/anotherClient";
    }
}
