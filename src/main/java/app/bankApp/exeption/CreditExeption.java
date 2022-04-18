package app.bankApp.exeption;

import app.entities.Credit;

public class CreditExeption extends Exception{
        public CreditExeption(String message, Credit credit, double pay) {
            super(message);
            credit.setMoney(credit.getAmount());
        }
}
