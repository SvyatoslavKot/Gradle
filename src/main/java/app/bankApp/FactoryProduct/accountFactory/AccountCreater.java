package app.bankApp.FactoryProduct.accountFactory;

import app.bankApp.Bank;
import app.entities.Account;
import app.entities.Client;

public interface AccountCreater {
    Account create(Bank bank, Client client, int creditTerm, String pin, String level);
}
