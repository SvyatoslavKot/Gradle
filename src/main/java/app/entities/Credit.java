package app.entities;

import app.bankApp.Bank;
import app.bankApp.FactoryProduct.CreditFactory.CreditCreater;

import java.util.Date;

public class Credit implements CreditCreater {
    private String creditName ;
    private String accountNumber ;
    private int amount ;
    private double ptc ;
    private Date openingDate;
    private int creditTerm;
    private double paymentMonth;
    private String idHolder;

    public Credit() {
    }

    public Credit(String creditName, String accountNumber, int amount, double ptc, int creditTerm, double paymentMonth, String idHolder) {
        this.creditName = creditName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.ptc = ptc;
        this.openingDate = openingDate;
        this.creditTerm = creditTerm;
        this.paymentMonth = paymentMonth;
        this.idHolder = idHolder;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPtc() {
        return ptc;
    }

    public void setPtc(double ptc) {
        this.ptc = ptc;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public double getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(double paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public String getIdHolder() {
        return idHolder;
    }

    public void setIdHolder(String idHolder) {
        this.idHolder = idHolder;
    }

    @Override
    public void create(Bank bank, Client client, int sum, String type, int creditTerm) {

    }
}
