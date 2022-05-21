package ru.bankApp.app.entities;

import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.creditFactory.Credit;

public interface Product {

    Account create(Client client, int creditTerm, String pin, String level);
    Credit create( Client client, double sum, int creditTerm);

    public boolean reName (String name);

    public boolean setMoney(double money);

    public boolean getMoney(double money);

}
