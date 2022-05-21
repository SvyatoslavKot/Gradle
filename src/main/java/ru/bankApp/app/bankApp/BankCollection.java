package ru.bankApp.app.bankApp;
import ru.bankApp.app.entities.creditFactory.Credit;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.*;


import java.util.*;

/**
 * class BankCollection save data BankApp
 */
public class BankCollection {
    /**
     * collection for storing a list of clients
     */
    private HashMap<String, Client> clientHashMap = new HashMap<>();

    /**
     * collection for storing a list of All credits
     */
    private HashSet<Credit> creditListOfBank = new HashSet<>();

    private HashSet<Account> accountListOfBank = new HashSet<>();

    private HashMap<Integer, ApplyCredit> creditBids = new HashMap<>();

    public HashMap<Integer, ApplyCredit> getCreditBids() {
        return creditBids;
    }


    public HashMap<String,List<Reciept>> recieptForLogin = new HashMap<>();

    public HashMap<String,List<Reciept>> recieptForAccount = new HashMap<>();

    public HashMap<String,List<Reciept>> recieptForCredit = new HashMap<>();

    public HashMap<String,Employee> employeeHashMap = new HashMap<>();


    /**
     * @return clientHashMap
     */
    public HashMap<String, Client> getClientHashMap() {
        return clientHashMap;
    }

    /**
     *
     * @return creditList
     */
    public HashSet<Credit> getCreditListOfBank() {
        return creditListOfBank;
    }

    public HashSet<Account> getAccountList() {
        return accountListOfBank;
    }

    public HashMap<String, List<Reciept>> getRecieptForLogin() {
        return recieptForLogin;
    }

    public HashMap<String, List<Reciept>> getRecieptForAccount() {
        return recieptForAccount;
    }

    public HashMap<String, List<Reciept>> getRecieptForCredit() {
        return recieptForCredit;
    }

    public HashMap<String, Employee> getEmployeeHashMap() {
        return employeeHashMap;
    }
}
