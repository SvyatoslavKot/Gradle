package app.bankApp.exeption;

import app.entities.Credit;

public class RecieptNullEx extends Exception{
    public RecieptNullEx(String message) {
        super(message);
    }
}
