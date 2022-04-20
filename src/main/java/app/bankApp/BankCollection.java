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
    private HashSet<Credit> creditListOfBank = new HashSet<>();

    private HashSet<Account> accountListOfBank = new HashSet<>();

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
}
