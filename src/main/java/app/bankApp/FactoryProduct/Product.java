package app.bankApp.FactoryProduct;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;
import app.entities.Credit;

public interface Product {

    Account create(Bank bank, Client client, int creditTerm, String pin, String level);
    Credit create(Bank bank, Client client, double sum, int creditTerm);

    public boolean reName (String name);

    public boolean setMoney(double money);

    public boolean getMoney(double money);

}
