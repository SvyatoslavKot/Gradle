package ru.bankApp.app.bankApp.exeption;

import ru.bankApp.app.entities.creditFactory.Credit;

public class CreditExeption extends Exception{
        public CreditExeption(String message, Credit credit, double pay) {
            super(message);
            credit.pluseMoney(credit.getAmount());
        }
}
