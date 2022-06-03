package ru.bankApp.app.bankApp.serviceBank.moneyOperation;

import ru.bankApp.app.bankApp.exeption.AccountNotMoney;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.creditFactory.Credit;

public class MoneyOperation implements MoneyOperationInterface{


    @Override
    public void transferMoney(Account aSender, Account aAddressee, double value) throws AccountNotMoney {
        if (aSender.getMoney_in_account()>=value){
            if (aAddressee!=null){
                aAddressee.pluseMoney(value);
            }
            aSender.minusMoney(value);
        }else  throw new AccountNotMoney("Not enough money on balance");
    }

    @Override
    public void paymentCredit(Account aPayment, Credit cPay, double value) throws AccountNotMoney {
        if (aPayment.getMoney_in_account()>=value){
            if (cPay.getAmount() < value){
                value = cPay.getAmount();
            }
            aPayment.minusMoney(value);
            cPay.pluseMoney(value);
        }else throw new AccountNotMoney("Not enough money on balance");
    }

    @Override
    public void pay(Account a, double value) throws AccountNotMoney {
        if (a.getMoney_in_account()>=value){
            a.minusMoney(value);
        }else  throw new AccountNotMoney("Not enough money on balance");
    }
}
