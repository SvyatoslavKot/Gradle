package app.bankApp.serviceBank;

import app.bankApp.Bank;
import app.bankApp.BankCollection;
import app.entities.Client;

import java.util.HashMap;
import java.util.Map;

/**
 * Class login password check
 * indicate Class Bank and clientHashMap
 */
public class PasswordCheck {

    Bank bank = Bank.getInstance();
    HashMap<String, Client> clientHashMap = bank.getBankCollection().getClientHashMap();
    Client client;

    /**
     * When creating a class, using class Bank {@link Bank} which is Singleton ,
     * and ref HashMap {@link BankCollection#getClientHashMap()} with Client this Bank,
     * and object client type of {@link Client},
     * method chekPassword iterates clientHashMap and compares key and param nickName,
     * is true assing a value from the clientHashMap to the client when compare password and value {@link Client#getPassword()}
     * is true return Client else null
     * @param nickName
     * @param password
     * @return Client
     */
    public Client chekPassword(String nickName, String password) {
        for (Map.Entry entry : clientHashMap.entrySet()) {
            if (entry.getKey().equals(nickName)) {
                client = (Client) entry.getValue();
                if (client.getPassword().equals(password)) {
                    return client;
                }
            } else return null;
        }
        return null;
    }
}
