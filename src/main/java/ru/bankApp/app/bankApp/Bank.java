package ru.bankApp.app.bankApp;

/**
 * @author SvyatoslavK
 * class main object Bank
 * dev pattern Singleton
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
    /**
     * @param name
     */
    private Bank(String name) {
        this.name = name;
    }
    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return bankCollection
     * @see BankCollection
     */
    public BankCollection getBankCollection() {
        return bankCollection;
    }
}
