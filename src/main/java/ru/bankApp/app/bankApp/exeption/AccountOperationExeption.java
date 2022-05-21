package ru.bankApp.app.bankApp.exeption;

public class AccountOperationExeption extends Exception{
    int balace;

    public AccountOperationExeption(String msg) {
       super(msg);
    }
}
