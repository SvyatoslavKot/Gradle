package ru.bankApp.app.bankApp.serviceBank.moneyOperation;

import ru.bankApp.app.bankApp.exeption.AccountNotMoney;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.creditFactory.Credit;

public interface MoneyOperationInterface {

    public void transferMoney(Account aSender, Account aAddressee, double value) throws AccountNotMoney;

    public void paymentCredit(Account aPayment, Credit cPay, double value) throws AccountNotMoney;

    public void pay(Account a, double value) throws AccountNotMoney;
}
