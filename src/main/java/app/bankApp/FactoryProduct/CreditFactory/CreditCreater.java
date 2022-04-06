package app.bankApp.FactoryProduct.CreditFactory;

import app.bankApp.Bank;
import app.entities.Client;
import app.entities.Credit;

public interface CreditCreater {
    void create(Bank bank, Client client, int sum, String type, int creditTerm);
}
