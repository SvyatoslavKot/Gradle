package app.bankApp;
import app.entities.Client;
import java.util.HashMap;

public class BankCollection {
    private HashMap<String, Client> clientHashMap = new HashMap<>();
    private HashMap <String,String> passwordMap = new HashMap<>();

    public HashMap<String, Client> getClientHashMap() {
        return clientHashMap;
    }

    public HashMap<String, String> getPasswordMap() {
        return passwordMap;
    }
}
