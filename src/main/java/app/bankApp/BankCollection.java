package app.bankApp;
import app.entities.Client;
import app.entities.Credit;

import java.util.ArrayList;
import java.util.HashMap;

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
    private ArrayList<Credit> creditList = new ArrayList<>();

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
    public ArrayList<Credit> getCreditList() {
        return creditList;
    }
}
