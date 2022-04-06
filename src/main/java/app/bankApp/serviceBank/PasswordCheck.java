package app.bankApp.serviceBank;

import app.bankApp.Bank;
import app.entities.Client;

import java.util.HashMap;
import java.util.Map;

public class PasswordCheck {
    Bank bank = Bank.getInstance();
    HashMap<String, Client> clientHashMap = bank.getBankCollection().getClientHashMap();
    Client client;

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
