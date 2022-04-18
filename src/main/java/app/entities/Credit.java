package app.entities;

import app.bankApp.Bank;
import app.bankApp.FactoryProduct.CreditFactory.CreditCreater;
import app.bankApp.serviceBank.CreditCalculationPayment;
import app.bankApp.serviceBank.GenerateAccountNumber;

/**
 * class Credit implements
 * @see CreditCreater
 */
public class Credit implements Product, CreditCreater{
    private String creditName ;
    private String accountNumber ;
    private double amount ;
    private double ptc ;
    private String openingDate;
    private int creditTerm;
    private double paymentMonth;
    private String idHolder;

    GenerateAccountNumber genNum = new GenerateAccountNumber();
    CreditCalculationPayment creditPayment = new CreditCalculationPayment();
    public Credit() {
    }

    /**
     * Constructor create Credit class accepts all parameters except accountNumber,openingDate,paymentMonth
     * accountNumber created inside the this constructor with class {@link GenerateAccountNumber#accountNumber(int)}
     * param openingDate created default
     * param paymentMonth created inside with class {@link CreditCalculationPayment#calc(int, double, int)} which used parameters constructor
     * @param idHolder
     * @param creditName
     * @param amount
     * @param ptc
     * @param creditTerm
     */
    public Credit(Bank bank, String idHolder, String creditName, int amount, double ptc, int creditTerm) {
        this.creditName = creditName;
        this.accountNumber = genNum.accountNumber(bank.getBankCollection().getCreditListOfBank().size());
        this.amount = amount;
        this.ptc = ptc;
        this.openingDate = "01.01.2020";
        this.creditTerm = creditTerm;
        this.paymentMonth = creditPayment.calc(amount,17.9,creditTerm);
        this.idHolder = idHolder;
    }

    /**
     * @see CreditCreater
     * @param bank
     * @param client
     * @param sum
     * @param creditTerm
     */
    @Override
    public Credit create(Bank bank, Client client, int sum, int creditTerm) {
        return null;
    }
    @Override
    public boolean reName(String name) {
        if (!name.equals(" ")){
            this.setCreditName(name);
            return true;
        }
        else return false;
    }

    @Override
    public boolean setMoney(double money) {
        double balance;
        balance = this.getAmount() - money;
        this.setAmount(balance);
        return true;
    }

    @Override
    public boolean getMoney(double money) {
        return false;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPtc() {
        return ptc;
    }

    public void setPtc(double ptc) {
        this.ptc = ptc;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
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
    public String toString() {
        return "Credit{" +
                "creditName='" + creditName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", amount=" + amount +
                ", ptc=" + ptc +
                ", openingDate=" + openingDate +
                ", creditTerm=" + creditTerm +
                ", paymentMonth=" + paymentMonth +
                ", idHolder='" + idHolder + '\'' +
                '}';
    }


}
