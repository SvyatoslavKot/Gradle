package ru.bankApp.app.bankApp.exeption;

public class AccountNotMoney extends Exception{
    int balace;

    public AccountNotMoney(String msg) {
       super(msg);
    }
}
