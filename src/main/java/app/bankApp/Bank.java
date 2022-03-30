package app.bankApp;


/**
 * @author SvyatoslavK
 * класс банка
 * */
public class Bank {
    private String name;
    private BankCollection bankCollection;

    private static Bank bankSber = new Bank("Sber");

    public static Bank getInstance(){
        if (bankSber == null){
            return bankSber = new Bank("Sber");
        }else return bankSber;
    }

    private Bank(String name) {
        this.name = name;
        this.bankCollection = new BankCollection();
    }

    public String getName() {
        return name;
    }
}
