package app.bankApp.bankCollection;

import app.bankApp.Bank;
import app.bankApp.exeption.ClientAddExeption;
import app.entities.BidCredit;
import app.entities.Client;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceClientsCollection {
    Bank bank = Bank.getInstance();

    public Client getClientByPhone (String phone){
        Client c = bank.getBankCollection().getClientHashMap().get(phone);
        return  c;
    }

    public Client getClientById (String id) {
        HashMap<String, Client> clientHashMap = bank.getBankCollection().getClientHashMap();
        for (Map.Entry entry : clientHashMap.entrySet()) {
            Client c = (Client) entry.getValue();
            if (c.getId().equals(id)){
                return c;
            }
            return null;
        }
        return null;
    }

    public ArrayList<Client> getAllClients (){
        Collection<Client> values = bank.getBankCollection().getClientHashMap().values();
        ArrayList<Client> clientList = new ArrayList<>(values);
        return clientList;

    }
/*
    public HashMap<String,Client> getAllClients(){
        HashMap<String,Client> clientHashMap = bank.getBankCollection().getClientHashMap();
        return  clientHashMap;
    }*/

    public boolean addClient (Client client) throws ClientAddExeption {
        if (bank.getBankCollection().getClientHashMap().get(client.getMobilePhone()) != null){
                throw  new ClientAddExeption("Клиент с таким именем уже существует");
        } else bank.getBankCollection().getClientHashMap().put(client.getMobilePhone(),client);
        return true;
    }
    public  boolean deleteClient(Client client){
        if ( bank.getBankCollection().getClientHashMap().get(client.getMobilePhone())!= null){
            bank.getBankCollection().getClientHashMap().remove(client.getMobilePhone());
            return true;
        }
        return false;
    }
}
