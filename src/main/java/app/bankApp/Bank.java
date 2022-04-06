package app.bankApp;

import app.bankApp.DBtextformat.ReadClient;

/**
 * @author SvyatoslavK
 * класс банка
 * */
public class Bank {
    private String name;
    private BankCollection bankCollection = new BankCollection();


    private static Bank bankSber = new Bank("NAME of BANK");

    public static Bank getInstance(){
        if (bankSber == null){
            return bankSber = new Bank("NAME of BANK");
        }else return bankSber;
    }

    private Bank(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public BankCollection getBankCollection() {
        return bankCollection;
    }
}
