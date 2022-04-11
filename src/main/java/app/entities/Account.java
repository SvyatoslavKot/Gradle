package app.entities;

import app.bankApp.Bank;
import app.bankApp.FactoryProduct.accountFactory.AccountCreater;
import app.bankApp.serviceBank.GenerateAccountNumber;

public class Account  implements AccountCreater {
    private String nameAccount;
    private String accountNumber;
    private int moneyInAccount;
    // private DataFormat openingDate;
    private int creditTerm;
    private int payment;
    private double cashBack;
    private String idHolder;
    private String pin;

    GenerateAccountNumber genNum = new GenerateAccountNumber();



    public Account() {
    }

    public Account(Bank bank, String nameAccount, int creditTerm, int payment, double cashBack, String idHolder, String pin) {
        this.nameAccount = nameAccount;
        this.accountNumber = genNum.accountNumber(bank.getBankCollection().getCreditListOfBank().size());
        this.creditTerm = creditTerm;
        this.payment = payment;
        this.cashBack = cashBack;
        this.idHolder = idHolder;
        this.pin = pin;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getMoneyInAccount() {
        return moneyInAccount;
    }

    public void setMoneyInAccount(int moneyInAccount) {
        this.moneyInAccount = moneyInAccount;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public double getCashBack() {
        return cashBack;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public String getIdHolder() {
        return idHolder;
    }

    public void setIdHolder(String idHolder) {
        this.idHolder = idHolder;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Account{" +
                "nameAccount='" + nameAccount + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", moneyInAccount=" + moneyInAccount +
                ", creditTerm=" + creditTerm +
                ", payment=" + payment +
                ", cashBack=" + cashBack +
                ", idHolder='" + idHolder + '\'' +
                ", pin='" + pin + '\'' +
                ", genNum=" + genNum +
                '}';
    }


    @Override
    public Account create(Bank bank, Client client, int creditTerm, String pin, String level) {
        return null;
    }
}
