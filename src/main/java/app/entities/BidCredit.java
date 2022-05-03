package app.entities;

import app.bankApp.Bank;
import app.bankApp.bankCollection.ServiceBidCreditCollection;
import app.bankApp.bankCollection.ServiceClientsCollection;
import app.bankApp.bankCollection.ServiceCreditCollection;
import app.bankApp.serviceBank.GenerateAccountNumber;
import app.bankApp.tasksAdmin.StatusBidCreditEnum;

import java.util.ArrayList;
import java.util.Objects;

public class BidCredit {
    private int numBid;
    private String status;
    private Credit credit;
    private String clientPhone;
    private int child;
    private boolean family;
    private int income;
    private double otherCredit;
    private int experience;
    private int age;
    private double solvency;


    GenerateAccountNumber genNum = new GenerateAccountNumber();
    ServiceCreditCollection serviceCredit = new ServiceCreditCollection();
    ServiceClientsCollection serviceClient = new ServiceClientsCollection();

    public BidCredit( String status, Credit credit, String clientPhone, int child, boolean family, int income , double otherCredit, int experience, int age) {
        this.numBid = genNum.genBidNum();
        this.status = status;
        this.credit = credit;
        this.clientPhone = clientPhone;
        this.child = child;
        this.family = family;
        this.income = income;
        this.otherCredit = otherCredit;
        this.experience = experience;
        this.age = age;
        this.solvency = calckSolvency();

    }

    public double calckSolvency(){
        double otherPayment = 0;
        double kof = 1;
        Client client = serviceClient.getClientByPhone(this.credit.getPhoneHolder());
        ArrayList<Credit> credits = serviceCredit.getAccountByClient(client);

        if (child ==1){kof = kof+ 0.2;}
        else if (child ==2){kof = kof+ 0.3;}
        else if (child ==3){kof = kof+ 0.4;}
        else if (child >3){kof = kof+ 0.5;}

        if (experience == 0 ){kof = kof + 0.6;}
        else if (experience == 1 ){kof = kof + 0.5;}
        else if (experience == 2 ){kof = kof + 0.4;}
        else if (experience == 3 ){kof = kof + 0.3;}

        if (age < 19){kof = kof +0.6;}
        else if (age >= 19 && age<21){kof = kof +0.5;}
        else if (age >= 21 && age<27 && age >= 57){kof = kof +0.2;}

        if (credits.size()!=0){
            for (Credit c : credits){
               otherPayment = otherPayment + c.getPaymentMonth();
            }
        }

        otherPayment = otherPayment + otherCredit;
        return (income - otherPayment)/kof;
    }

    public void checkPaymentForSolvency(){
        double pay = this.credit.getPaymentMonth();
        double sol = this.solvency;
        if ((sol - pay) < 0){
            this.status = StatusBidCreditEnum.PREV_DENIED.status;
        }else {
            this.status = StatusBidCreditEnum.PREV_APPROVED.status;
        }
    }

    public int getNumBid() {
        return numBid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public int getChild() {
        return child;
    }

    public boolean isFamily() {
        return family;
    }

    public int getIncome() {
        return income;
    }

    public double getOtherCredit() {
        return otherCredit;
    }

    public int getExperience() {
        return experience;
    }

    public int getAge() {
        return age;
    }

    public double getSolvency() {
        return solvency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BidCredit bidCredit = (BidCredit) o;
        return numBid == bidCredit.numBid && child == bidCredit.child && family == bidCredit.family && income == bidCredit.income && Double.compare(bidCredit.otherCredit, otherCredit) == 0 && experience == bidCredit.experience && age == bidCredit.age && Double.compare(bidCredit.solvency, solvency) == 0 && Objects.equals(status, bidCredit.status) && Objects.equals(credit, bidCredit.credit) && Objects.equals(clientPhone, bidCredit.clientPhone) && Objects.equals(genNum, bidCredit.genNum) && Objects.equals(serviceCredit, bidCredit.serviceCredit) && Objects.equals(serviceClient, bidCredit.serviceClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numBid, status, credit, clientPhone, child, family, income, otherCredit, experience, age, solvency, genNum, serviceCredit, serviceClient);
    }
}
