package ru.bankApp.controller.moneyOperationControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank_app/money_operation/payment")
public class PaymentController {

    @GetMapping("/credit")
    public String creditView(){
        return "moneyOperationViews/payment/credit";
    }

    @GetMapping("/phone")
    public String phoneView(){
        return "moneyOperationViews/payment/phone";
    }
}
