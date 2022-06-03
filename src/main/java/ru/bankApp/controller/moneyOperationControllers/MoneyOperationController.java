package ru.bankApp.controller.moneyOperationControllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank_app/client/money_operation/")
public class MoneyOperationController {
    @GetMapping("/main")
    public String mainView(){
        return "moneyOperationViews/moneyOperationMain";
    }

    @GetMapping("/payment")
    public String paymentView (){
        return "moneyOperationViews/payment/moneyOperationPayment";
    }

    @GetMapping("/transfer")
    public String transferView (){
        return "moneyOperationViews/transfer/moneyOperationTransfer";
    }

    @GetMapping("/history")
    public String historyView (){
        return "moneyOperationViews/moneyOperationHistory";
    }
}
