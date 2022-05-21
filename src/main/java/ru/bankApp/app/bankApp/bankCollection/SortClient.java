package ru.bankApp.app.bankApp.bankCollection;

import ru.bankApp.app.entities.Client;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortClient {


    public List<Client> sortByIdLow(List<Client> clients) {

        //List list = new ArrayList(clients);
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return 0;
            }
        });

        return clients;
    }
    public List<Client> sortByIdHeight(List<Client> clients) {
        //List list = new ArrayList(clients);
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return 0;
            }
        });
        return clients;
    }
}
