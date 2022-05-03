package app.bankApp.bankCollection;

import app.entities.Client;
import app.entities.Credit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortClient {
        ServiceClientsCollection serviceClient = new ServiceClientsCollection();

    public List<Client> sortByIdLow(List<Client> clients) {

        //List list = new ArrayList(clients);
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        return clients;
    }
    public List<Client> sortByIdHeight(List<Client> clients) {
        //List list = new ArrayList(clients);
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return -(o1.getId().compareTo(o2.getId()));
            }
        });
        return clients;
    }
}
