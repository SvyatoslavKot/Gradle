package app.bankApp;
import app.entities.Account;
import app.entities.Client;
import app.entities.Credit;

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
    private ArrayList<Credit> creditListOfBank = new ArrayList<>();

    private ArrayList<Account> accountListOfBank = new ArrayList<>();

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
    public ArrayList<Credit> getCreditListOfBank() {
        return creditListOfBank;
    }

    public ArrayList<Account> getAccountList() {
        return accountListOfBank;
    }
}
