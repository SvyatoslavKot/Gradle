package app.bankApp.bankCollection;

import app.entities.Client;
import app.entities.Credit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortClient {


    public List<Client> sortByIdLow(List<Client> clients) {
        List list = new ArrayList(clients);
        Collections.sort(list, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        return list;
    }
    public List<Client> sortByIdHeight(List<Client> clients) {
        List list = new ArrayList(clients);
        Collections.sort(list, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });
        return list;
    }
}
