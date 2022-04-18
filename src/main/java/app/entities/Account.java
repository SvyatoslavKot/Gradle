package app.entities;

import app.bankApp.Bank;
import app.bankApp.FactoryProduct.CreditFactory.CreditCreater;
import app.bankApp.FactoryProduct.accountFactory.AccountCreater;
import app.bankApp.FactoryProduct.accountFactory.StandartAccount;
import app.bankApp.serviceBank.GenerateAccountNumber;
/**
 * @author SvyatoslavK
 * create Account implements interface  {@link AccountCreater#create(Bank, Client, int, String, String)} , this entities Account object
 * */
public  class  Account  implements Product,AccountCreater {
    private String nameAccount;
    private String accountNumber;
    private double moneyInAccount;
    // private DataFormat openingDate;
    private int creditTerm;
    private double payment;
    private double cashBack;
    private String idHolder;
    private String pin;
    private boolean lock = false;

    GenerateAccountNumber genNum = new GenerateAccountNumber();


    /**
     * default constructor
     */
    public Account() {
    }

    /**
     * constructor create Object Account accepts all parameters except accountNumber and MoneyInAccount
     * accountNumber created inside the this constructor with class {@link GenerateAccountNumber#accountNumber(int)}
     * @param bank
     * @param nameAccount
     * @param creditTerm
     * @param payment
     * @param cashBack
     * @param idHolder
     * @param pin
     */
    public Account(Bank bank, String nameAccount, int creditTerm, double payment, double cashBack, String idHolder, String pin) {
        this.nameAccount = nameAccount;
        this.accountNumber = genNum.accountNumber(bank.getBankCollection().getCreditListOfBank().size());
        this.creditTerm = creditTerm;
        this.payment = payment;
        this.cashBack = cashBack;
        this.idHolder = idHolder;
        this.pin = pin;
    }
    @Override
    public boolean reName(String name) {
        if (name.equals(" ")){
            return true;
        }else
        return false;
    }
    @Override
    public boolean setMoney(double money) {
        double balance;
        balance = this.getMoneyInAccount() + money;
        this.setMoneyInAccount(balance);
        return true;
    }

    @Override
    public boolean getMoney(double money)  {
       if (money <= this.getMoneyInAccount()){
           double balance;
           balance = this.getMoneyInAccount() - money;
           this.setMoneyInAccount(balance);
           return true;
       }
        return false;
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

    public double getMoneyInAccount() {
        return moneyInAccount;
    }

    public void setMoneyInAccount(double moneyInAccount) {
        this.moneyInAccount = moneyInAccount;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
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

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
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
